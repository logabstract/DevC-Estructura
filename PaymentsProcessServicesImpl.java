
package pe.com.scotiabank.tbk.payment.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.scotiabank.tbk.payment.beans.Account;
import pe.com.scotiabank.tbk.payment.beans.CTS;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderDetail;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderDetailRequest;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderHeader;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderHeaderRequest;
import pe.com.scotiabank.tbk.payment.beans.PreOrderDetailInput;
import pe.com.scotiabank.tbk.payment.beans.PreOrderHeaderInput;
import pe.com.scotiabank.tbk.payment.converters.PaymentsProcessGenerator;
import pe.com.scotiabank.tbk.payment.response.PreOrderCopyResponse;
import pe.com.scotiabank.tbk.payment.response.PreOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessOrder;
import pe.com.scotiabank.tbk.payment.response.ProcessPreliquidateServiceResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessSheduleServiceOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateAccountsResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateOrderStructureResponse;
import pe.com.scotiabank.tbk.payment.response.ValidatePreOrderResponse;
import pe.com.scotiabank.tbk.payment.services.PaymentsProcessServices;
import pe.com.scotiabank.tbk.payment.tramas.converter.TREMConverter;
import pe.com.scotiabank.tbk.payment.tramas.converter.TRSGConverter;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TB2WFileInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileDetailInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileHeaderInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TB2WInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRCVInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TREMInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TROPInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRPEInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRPNInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRPOInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRROInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRSGInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRVCInput;
import pe.com.scotiabank.tbk.payment.tramas.input.TRVNInput;
import pe.com.scotiabank.tbk.payment.tramas.output.TB2WOutput;
import pe.com.scotiabank.tbk.payment.tramas.output.TRCVOutput;
import pe.com.scotiabank.tbk.payment.tramas.output.TREMOutput;
import pe.com.scotiabank.tbk.payment.tramas.output.TRPOOutput;
import pe.com.scotiabank.tbk.payment.tramas.output.TRROOutput;
import pe.com.scotiabank.tbk.payment.tramas.output.TRSGOutput;
import pe.com.scotiabank.tbk.payment.tramas.output.TRVCOutput;
import pe.com.scotiabank.tbk.payment.tramas.output.TRVNOutput;
import pe.com.scotiabank.tbk.payment.util.PaymentWsConstants;
import pe.com.scotiabank.tbk.payment.util.PaymentWsFunctions;
import pe.com.scotiabank.tbk.payment.util.PaymentWsUtils;
//import pe.com.scotiabank.tbk.transfers.response.CommissionResponse;
import pe.com.scotiabank.tbk.util.beans.Header;
import pe.com.scotiabank.tbk.util.beans.Response;
import pe.com.scotiabank.tbk.util.beans.Status;
import pe.com.scotiabank.tbk.util.beans.User;
import pe.com.scotiabank.tbk.util.dao.ConnectAS400;
import pe.com.scotiabank.tbk.util.exception.ExceptionMessage;
import pe.com.scotiabank.tbk.util.exception.TBKWebServiceGenericException;
import pe.com.scotiabank.tbk.util.ftp.FTPExtractor;
import pe.com.scotiabank.tbk.util.trama.GenerateTrama;
import pe.com.scotiabank.tbk.util.trama.Trama;
import pe.com.scotiabank.tbk.util.utilities.Constants;
import pe.com.scotiabank.tbk.util.utilities.Functions;

public class PaymentsProcessServicesImpl implements PaymentsProcessServices
{

    private static final Logger log = LoggerFactory.getLogger(PaymentsProcessServicesImpl.class);

    private ConnectAS400 connectAS400;

    public ConnectAS400 getConnectAS400()
    {
        return connectAS400;
    }

    public void setConnectAS400(ConnectAS400 connectAS400)
    {
        this.connectAS400 = connectAS400;
    }

    @Override
    public ValidatePreOrderResponse validatePreOrder(User user, String sequence, String order)
            throws TBKWebServiceGenericException
    {

        Trama tramaTRCV;
        Map<String, Trama> tramaGenerics = new HashMap<>();
        ValidatePreOrderResponse response = null;

        try
        {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            user.setCompanySecuence(sequence);

            TRCVInput trcv = new TRCVInput(order);

            Set<ConstraintViolation<TRCVInput>> constraintViolations = validator.validate(trcv);

            if (constraintViolations.size() == 0)
            {

                user.setCompanySecuence(sequence);
                tramaTRCV = GenerateTrama.createTrama(PaymentWsConstants.TRCV, user, trcv);
                System.out.println(tramaTRCV.generateStringTramaToSend());
                String output = getConnectAS400().executeAS400Call(tramaTRCV.generateStringTramaToSend());
                tramaTRCV.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));
                tramaTRCV.setOutputBody(new TRCVOutput(output.substring(Constants.TBK_LENGHT_TRAMA, output.length())));
                tramaGenerics.put(PaymentWsConstants.TRCV, tramaTRCV);

                response = PaymentsProcessGenerator.generateValidatePreOrderResponse(tramaGenerics);

                response.setStatus(
                        new Status(Constants.TBK_RESPONSE_SUCCESS_CODE, Constants.TBK_RESPONSE_SUCCESS_MESSAGE));
            }
            else
            {
                for (ConstraintViolation<TRCVInput> constraintViolation : constraintViolations)
                {
                    System.out.println(constraintViolation.getMessage());
                }
            }
        }
        catch (Exception e)
        {
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
            e.printStackTrace();
            throw new TBKWebServiceGenericException(e.getMessage(),
                    new ExceptionMessage("Error al obtener informacion de ValidatePreOrderResponse",
                            Constants.HTTP_INTERNAL_SERVER_ERROR_CODE));
        }

        return response;
    }

    @Override
    public ValOrderResponse validateOrder(User user, String sequence, String order) throws TBKWebServiceGenericException
    {
        Trama tramaTRVN;
        Map<String, Trama> tramaGenerics = new HashMap<>();
        ValOrderResponse response = null;

        try
        {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            user.setCompanySecuence(sequence);

            TRVNInput trvn = new TRVNInput(order);

            Set<ConstraintViolation<TRVNInput>> constraintViolations = validator.validate(trvn);

            if (constraintViolations.size() > 0)
            {
                throw new Exception("Error en los parametros de entrada - Detalle: "
                        + constraintViolations.iterator().next().getMessage());
            }

            user.setCompanySecuence(sequence);

            tramaTRVN = GenerateTrama.createTrama(PaymentWsConstants.TRVN, user, trvn);
            String output = getConnectAS400().executeAS400Call(tramaTRVN.generateStringTramaToSend());

            tramaTRVN.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));
            tramaTRVN.setOutputBody(new TRVNOutput(output.substring(Constants.TBK_LENGHT_TRAMA, output.length())));
            tramaGenerics.put(PaymentWsConstants.TRVN, tramaTRVN);

            response = PaymentsProcessGenerator.generateValidateOrderResponse(tramaGenerics);
        }
        catch (Exception e)
        {
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
            e.printStackTrace();
            throw new TBKWebServiceGenericException(e.getMessage(),
                    new ExceptionMessage("Error al obtener informacion de ValidateOrderResponse",
                            Constants.HTTP_INTERNAL_SERVER_ERROR_CODE));
        }

        return response;
    }

    @Override
    public ValidateOrderStructureResponse validateOrderStructure(User user, String sequence, String order,
            String paymentType, String template, String chargeAccount, String processDate, String chargeCurrency,
            String chargeAmount, String userName, String recordCount, String reference, String flagIndicator,
            String uuidUploadFile, String uuidDownloadFile) throws TBKWebServiceGenericException
    {
        Trama tramaTREM;
        Map<String, Trama> tramaGenerics = new HashMap<>();
        ValidateOrderStructureResponse response = null;

        try
        {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            TREMInput trem = new TREMInput(user.getContract(), paymentType, template, chargeAccount, processDate,
                    chargeCurrency, chargeAmount, order, sequence, user.getUserCode(), userName, recordCount, reference,
                    flagIndicator);

            Set<ConstraintViolation<TREMInput>> constraintViolations = validator.validate(trem);

            if (constraintViolations.size() > 0)
            {
                throw new Exception("Error en los parametros de entrada - Detalle: "
                        + constraintViolations.iterator().next().getMessage());
            }

            if (PaymentWsConstants.TBK_TREM_VALIDATION_FLAG.equals(flagIndicator))
            {
                String localFileName = null;
                // valida contenido de archivo recibido
                File file = new File(
                        Functions.getValueFromProperties(PaymentWsConstants.KEY_FTP_UPLOAD) + uuidUploadFile);
                if (!file.isFile() || file.length() == 0)
                {
                    throw new Exception("El archivo del usuario no ha sido encontrado o no tiene datos");
                }

                // valida la extension del archivo recibido
                if (PaymentWsConstants.TBK_TREM_ZIP_FORMAT.equals(Functions.getExtension(file)))
                {
                    log.info("archivo tipo ZIP");
                    localFileName = Functions.unZipFile(file).getName();
                }
                else if (PaymentWsConstants.TBK_TREM_TXT_FORMAT.equals(Functions.getExtension(file)))
                {
                    log.info("archivo tipo TXT");
                    
                    // Se quita la extension a archivo TXT
                    Path source = Paths.get(Functions.getValueFromProperties(PaymentWsConstants.KEY_FTP_UPLOAD) + uuidUploadFile);
                    File renamedFile = Files.move(source, source.resolveSibling(Functions.getFileBaseName(file)), StandardCopyOption.REPLACE_EXISTING).toFile();
                    localFileName = renamedFile.getName();
                }
                else
                {
                    throw new Exception("Formatos de archivo no soportados: solo TXT o ZIP");
                }

                // BEGIN forma nombre file
                String sufixFile = trem.getContract().substring(1, trem.getContract().length()) + trem.getOrder();

                String fileRemoteName = PaymentWsConstants.TBK_TREM_FILE_UPLOAD_PREFIX
                        + PaymentWsConstants.TBK_TREM_LENGHT_MEMBER_UPLOAD_CHAR + sufixFile;
                // END forma nombre file

                boolean indUploadHeaderFile = FTPExtractor.getInstance().uploadFTP(localFileName, fileRemoteName);
                if (indUploadHeaderFile)
                {
                    user.setCompanySecuence(sequence);
                    tramaTREM = GenerateTrama.createTrama(PaymentWsConstants.TREM, user, trem);
                    String output = getConnectAS400().executeAS400Call(tramaTREM.generateStringTramaToSend());

                    tramaTREM.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));

                    if (!tramaTREM.getHeaderOutput().isValid())
                    {
                        return new ValidateOrderStructureResponse(
                                new Status(tramaTREM.getHeaderOutput().getError(), output.substring(
                                        Constants.TBK_LENGHT_TRAMA, Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150)));
                    }

                    tramaTREM.setOutputBody(
                            new TREMOutput(output.substring(Constants.TBK_LENGHT_TRAMA, output.length())));
                    tramaGenerics.put(PaymentWsConstants.TREM, tramaTREM);

                    response = PaymentsProcessGenerator.generateValidateOrderStructureResponse(tramaGenerics);
                }
            }
            else if (PaymentWsConstants.TBK_TREM_SCHEDULE_FLAG.equals(flagIndicator)) // Flag N 

            {
                // BEGIN extrae lineas de error del archivo de errores

                File errorsfile = new File(
                        Functions.getValueFromProperties(PaymentWsConstants.KEY_FTP) + uuidDownloadFile);

                // valida contenido de archivo recibido
                if (!errorsfile.isFile())
                {
                    throw new Exception("El archivo de errores no ha sido encontrado");
                }
                log.info("archivo de errores encontrado");

                List<Integer> errorLines = getErrorLines(errorsfile);
                log.info("se obtuvieron las lineas de error del archivo de errores");

                // END extrae lineas de error del archivo de errores

                // BEGIN actualiza archivo original
                
                File userFile = new File(Functions.getValueFromProperties(PaymentWsConstants.KEY_FTP_UPLOAD)
                        + Functions.getFileBaseName(uuidUploadFile));

                if (!userFile.isFile() || userFile.length() == 0)
                {
                    throw new Exception("El archivo del usuario no ha sido encontrado o no tiene datos");
                }

                log.info("inicia actualizacion de archivo original");
                
                userFile = deleteWrongLines(userFile, errorLines);
                
                log.info("archivo original corregido");
                
                // END actualiza archivo original

                // BEGIN forma nombre file
                String sufixFile = trem.getContract().substring(1, trem.getContract().length()) + trem.getOrder();

                String fileRemoteName = PaymentWsConstants.TBK_TREM_FILE_UPLOAD_PREFIX
                        + PaymentWsConstants.TBK_TREM_LENGHT_MEMBER_UPLOAD_CHAR + sufixFile;
                // END forma nombre file

                log.info("inicio subida de archivo original corregido");
                boolean indUploadHeaderFile = FTPExtractor.getInstance()
                        .uploadFTP(Functions.getFileBaseName(userFile), fileRemoteName);
                log.info("fin subida de archivo original corregido");
                if (indUploadHeaderFile)
                {
                    user.setCompanySecuence(sequence);
                    tramaTREM = GenerateTrama.createTrama(PaymentWsConstants.TREM, user, trem);
                    String output = getConnectAS400().executeAS400Call(tramaTREM.generateStringTramaToSend());
                    tramaTREM.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));
                    String code = tramaTREM.getHeaderOutput().getError();
                    String message = "";
                    if (!tramaTREM.getHeaderOutput().isValid())
                    {
                        message = output.substring(Constants.TBK_LENGHT_TRAMA,
                                Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150);
                    }
                    else
                    {
                        message = Constants.TBK_RESPONSE_SUCCESS_MESSAGE;
                    }
                    response = new ValidateOrderStructureResponse(code, message);
                }
            }
            else
            {
                File file = new File(PaymentWsUtils.getValueFromProperties(PaymentWsConstants.KEY_FTP) + uuidDownloadFile);
                if (file.isFile() && file.length() > 0)
                {

                    TREMOutput tremOutput = new TREMOutput();
                    tremOutput.readAllFile(file);

                    response = new TREMConverter.ConverterOutputToValidateOrderStructureResponse().convert(tremOutput);
                    response.setStatus(
                            new Status(Constants.TBK_RESPONSE_SUCCESS_CODE, Constants.TBK_RESPONSE_SUCCESS_MESSAGE));

                    return response;
                }
                else
                {
                    throw new Exception("El archivo no ha sido encontrado o no tiene datos");
                }
            }
        }

        catch (Exception e)
        {
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
            e.printStackTrace();
            throw new TBKWebServiceGenericException(e.getMessage(),
                    new ExceptionMessage("Error al obtener informacion de ValidateOrderStructureResponse",
                            Constants.HTTP_INTERNAL_SERVER_ERROR_CODE));
        }

        return response;
    }

    private File deleteWrongLines(File userFile, List<Integer> errorLines)
    {
        File tempFile = new File(userFile.getAbsolutePath() + PaymentWsConstants.TBK_TREM_TEMPFILE_EXTENSION);
        try
        {
            String line = null;
            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new FileInputStream(userFile)));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            while ((line = lnr.readLine()) != null)
            {
                int lineNumber = lnr.getLineNumber();
                if (!errorLines.contains(lineNumber))
                {
                    pw.println(line);
                    pw.flush();
                }
                else
                {
                    log.info("deleted line : " + lineNumber + " ->" + line + "<-");
                }
            }

            lnr.close();
            pw.close();

            if (!userFile.delete())
            {
                log.error("no se pudo borrar archivo original");
            }

            if (!tempFile.renameTo(userFile))
            {
                log.error("No se pudo renombrar archivo original");
            }
        }
        catch (IOException e)
        {
            log.error("Error leer archivo de errores", e);
        }

        return tempFile;
    }

    private List<Integer> getErrorLines(File errorsfile)
    {
        String contentFileOutput = null;

        List<Integer> errors = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(errorsfile))))
        {

            while ((contentFileOutput = br.readLine()) != null)
            {
                String lineNumber = contentFileOutput.substring(0, PaymentWsConstants.TBK_TREM_LENGHT_LINE);
                errors.add(Integer.parseInt(lineNumber.trim()));
            }

            br.close();
        }
        catch (IOException e)
        {
            log.error("Error leer archivo de errores", e);
        }
        return errors;
    }

    public Response savePreOrder(User user, MaintainPreOrderHeaderRequest preOrderHeader,
            MaintainPreOrderDetailRequest preOrderDetail) throws TBKWebServiceGenericException
    {
        Trama trama;
        String cadenaInput;
        Map<String, Trama> tramasGenerics = new HashMap<>();
        Response response = null;
        String code;
        String message;
        Status status;

        try
        {
            String order = preOrderHeader.getOrder();
            String action = preOrderHeader.getAction();
            String orderType = preOrderHeader.getOrderType();
            String sequence = preOrderHeader.getSequence();
            String currency = preOrderHeader.getCurrency();;

            MaintainPreOrderHeader header = new MaintainPreOrderHeader(user.getContract(), order, action, orderType,
                    sequence, user.getUserCode(), currency);

            preOrderDetail.setDueDate(PaymentWsFunctions.convertStrDateddMMyyy(preOrderDetail.getDueDate(), PaymentWsConstants.FORMAT_INIT_DATE, PaymentWsConstants.FORMAT_FINAL_DATE));
            preOrderDetail.setInvoiceDate(PaymentWsFunctions.convertStrDateddMMyyy(preOrderDetail.getInvoiceDate(), PaymentWsConstants.FORMAT_INIT_DATE, PaymentWsConstants.FORMAT_FINAL_DATE));


            MaintainPreOrderDetail detail = new MaintainPreOrderDetail(preOrderDetail.getCorrelative(),
                    preOrderDetail.getDetailUser(), preOrderDetail.getDocumentType(),
                    preOrderDetail.getDocumentNumber(), preOrderDetail.getEmployeeCode(),
                    preOrderDetail.getBeneficiary(), preOrderDetail.getEmail(), preOrderDetail.getReferencePv(),
                    preOrderDetail.getPaymentConcept(), preOrderDetail.getDocumentSign(),
                    preOrderDetail.getInvoiceNumber(), preOrderDetail.getAmount(), preOrderDetail.getSinglePayment(),
                    preOrderDetail.getPaymentFactoring(), preOrderDetail.getNoPayment(),
                    preOrderDetail.getMethodPayment(), preOrderDetail.getAccount(), preOrderDetail.getCci(),
                    preOrderDetail.getState(), preOrderDetail.getDueDate(), preOrderDetail.getInvoiceDate());
            TRPOInput trpo = new TRPOInput(header, detail);
            trama = GenerateTrama.createTrama(PaymentWsConstants.TRPO, user, trpo);
            cadenaInput = trama.generateStringTramaToSend();
            String output = getConnectAS400().executeAS400Call(cadenaInput);
            trama.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));
            if (!trama.getHeaderOutput().isValid())
            {
                code = trama.getHeaderOutput().getError();
                message = output.substring(Constants.TBK_LENGHT_TRAMA, Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150);
                status = new Status(code, message);
                return new Response(status);
            }
            String outputBody = output.substring(Constants.TBK_LENGHT_TRAMA, output.length());
            TRPOOutput trpooutput = new TRPOOutput(outputBody);
            trama.setOutputBody(trpooutput);
            tramasGenerics.put(PaymentWsConstants.TRPO, trama);
            response = PaymentsProcessGenerator.generateMaintainPreOrderResponse(tramasGenerics);
            code = Constants.TBK_RESPONSE_SUCCESS_CODE;
            message = Constants.TBK_RESPONSE_SUCCESS_MESSAGE;
            status = new Status(code, message);
            response.setStatus(status);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response deletePreOrder(User user, String order, String correlative) throws TBKWebServiceGenericException
    {
        Trama trama;
        String cadenaInput;
        Map<String, Trama> tramasGenerics = new HashMap<>();
        Response response = null;
        String code;
        String message;
        Status status;

        try
        {
            MaintainPreOrderHeader header = new MaintainPreOrderHeader(user.getContract(), order,
                    PaymentWsConstants.TBK_TRPO_ACTION_DELETE, "", "", user.getUserCode(), "");

            MaintainPreOrderDetail detail = new MaintainPreOrderDetail(correlative, "", "", "", "", "", "", "", "", "",
                    "", "", "", "", "", "", "", "", "", "", "");
            TRPOInput trpo = new TRPOInput(header, detail);
            trama = GenerateTrama.createTrama(PaymentWsConstants.TRPO, user, trpo);
            cadenaInput = trama.generateStringTramaToSend();
            String output = getConnectAS400().executeAS400Call(cadenaInput);
            trama.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));
            if (!trama.getHeaderOutput().isValid())
            {
                code = trama.getHeaderOutput().getError();
                message = output.substring(Constants.TBK_LENGHT_TRAMA, Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150);
                status = new Status(code, message);
                return new Response(status);
            }
            String outputBody = output.substring(Constants.TBK_LENGHT_TRAMA, output.length());
            TRPOOutput trpooutput = new TRPOOutput(outputBody);
            trama.setOutputBody(trpooutput);
            tramasGenerics.put(PaymentWsConstants.TRPO, trama);
            response = PaymentsProcessGenerator.generateMaintainPreOrderResponse(tramasGenerics);
            code = Constants.TBK_RESPONSE_SUCCESS_CODE;
            message = Constants.TBK_RESPONSE_SUCCESS_MESSAGE;
            status = new Status(code, message);
            response.setStatus(status);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
        }
        return response;
    }

    @Override
    public ProcessPreliquidateServiceResponse processPreliquidateService(User user, String sequence,
            TB2WFileInput[] fileInput) throws TBKWebServiceGenericException
    {
        Trama trama;
        String cadenaInput;
        Map<String, Trama> tramasGenerics = new HashMap<>();
        ProcessPreliquidateServiceResponse response = null;
        String code;
        String message;
        Status status;

        try
        {
            String contract = user.getContract();
            String userCode = user.getUserCode();
            user.setCompanySecuence(sequence);

            List<String> fileContent = getFileContent(fileInput);
            File file = getFile();
            PaymentWsFunctions.createFile(file, fileContent);
            String remoteFileName = getRemoteFileName(contract, userCode);
            FTPExtractor.getInstance().uploadFTP(file.getName(), remoteFileName);

            TB2WInput tb2w = new TB2WInput(contract, userCode, sequence);
            trama = GenerateTrama.createTrama(PaymentWsConstants.TB2W, user, tb2w);
            cadenaInput = trama.generateStringTramaToSend();
            String output = getConnectAS400().executeAS400Call(cadenaInput);
            trama.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));

            if (!trama.getHeaderOutput().isValid())
            {
                code = trama.getHeaderOutput().getError();
                message = output.substring(Constants.TBK_LENGHT_TRAMA, Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150);
                status = new Status(code, message);
                return new ProcessPreliquidateServiceResponse(status);
            }
            String outputBody = output.substring(Constants.TBK_LENGHT_TRAMA, output.length());
            TB2WOutput tb2wOutPut = new TB2WOutput(outputBody);
            trama.setOutputBody(tb2wOutPut);
            tramasGenerics.put(PaymentWsConstants.TB2W, trama);
            response = PaymentsProcessGenerator.generateProcessPreliquidateServiceResponse(tramasGenerics);
            code = Constants.TBK_RESPONSE_SUCCESS_CODE;
            message = Constants.TBK_RESPONSE_SUCCESS_MESSAGE;
            status = new Status(code, message);
            response.setStatus(status);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
        }
        return response;
    }

    public File getFile()
    {
        String localFileName = UUID.randomUUID().toString();
        return new File(FTPExtractor.getInstance().getLocalPathUpload(), localFileName);
    }

    public String getRemoteFileName(String contract, String userCode)
    {
        return PaymentWsConstants.TBK_TB2W_FILE_UPLOAD_PREFIX + PaymentWsConstants.TBK_UPLOAD_FILE
                + StringUtils.leftPad(contract, PaymentWsConstants.TBK_ATTR_LENGTH_CONTRACT,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR)
                + StringUtils.leftPad(userCode, PaymentWsConstants.TBK_ATTR_LENGTH_USER_CODE,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
    }

    public String getRemoteFileName(String prefix, String contract, String order)
    {
        return prefix + PaymentWsConstants.TBK_UPLOAD_FILE
                + StringUtils.leftPad(contract, PaymentWsConstants.TBK_TRSG_LENGTH_CONTRACT_HEADER,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR)
                + StringUtils.leftPad(order, PaymentWsConstants.TBK_TRSG_LENGTH_ORDER,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
    }

    public List<String> getFileContent(TB2WFileInput[] fileInput)
    {
        List<String> lista = new ArrayList<String>();
        for (TB2WFileInput tb2wFileInput : fileInput)
        {
            lista.add(tb2wFileInput.toString());
        }
        return lista;
    }

    public List<String> getFileContent(PreOrderHeaderInput header)
    {
        List<String> lista = new ArrayList<String>();
        lista.add(header.toString());
        return lista;
    }

    @Override
    public ProcessSheduleServiceOrderResponse processSheduleServiceOrder(User user, String order, String paymentType,
            String chargeAccount, String programmeDate, String reference, String receibtTotal,
            TRSGFileHeaderInput trsgFileHeaderInput, TRSGFileDetailInput[] trsgFileDetailInput)
            throws TBKWebServiceGenericException
    {
        trsgFileHeaderInput.setOrder(order);
        PreOrderHeaderInput header = new TRSGConverter.ConverterTRSGFileHeaderInputToPreOrderHeaderInput()
                .convert(trsgFileHeaderInput);
        trsgFileDetailInput = getDetailsWithCurrency(trsgFileDetailInput, header.getCurrency());
        PreOrderDetailInput[] details = new TRSGConverter.ConverterTRSGFileDetailInputToPreOrderDetailInput()
                .convert(trsgFileDetailInput);

        List<String> fileContent = getFileContent(header);
        File file = getFile();
        PaymentWsFunctions.createFile(file, fileContent);

        String remoteFileName = getRemoteFileName(PaymentWsConstants.TBK_TRSG_FILE_UPLOAD_HEADER_PREFIX,
                user.getContract(), order);
        FTPExtractor.getInstance().uploadFTP(file.getName(), remoteFileName);

        fileContent = getFileContent(details);
        file = getFile();
        PaymentWsFunctions.createFile(file, fileContent);
        remoteFileName = getRemoteFileName(PaymentWsConstants.TBK_TRSG_FILE_UPLOAD_DETAIL_PREFIX, user.getContract(),
                order);
        FTPExtractor.getInstance().uploadFTP(file.getName(), remoteFileName);

        Trama trama;
        String cadenaInput;
        Map<String, Trama> tramasGenerics = new HashMap<>();
        ProcessSheduleServiceOrderResponse response = null;
        String code;
        String message;
        Status status;
        TRSGInput trsg = new TRSGInput(order, paymentType, chargeAccount, programmeDate, reference, receibtTotal);
        trsg.setMember(user.getContract());

        user.setCompanySecuence(header.getCompanySequence());
        trama = GenerateTrama.createTrama(PaymentWsConstants.TRSG, user, trsg);
        cadenaInput = trama.generateStringTramaToSend();
        String output = getConnectAS400().executeAS400Call(cadenaInput);
        trama.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));

        if (!trama.getHeaderOutput().isValid())
        {
            code = trama.getHeaderOutput().getError();
            message = output.substring(Constants.TBK_LENGHT_TRAMA, Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150);
            status = new Status(code, message);
            return new ProcessSheduleServiceOrderResponse(status);
        }

        String outputBody = output.substring(Constants.TBK_LENGHT_TRAMA, output.length());
        TRSGOutput trsgOutPut = new TRSGOutput(outputBody);
        trama.setOutputBody(trsgOutPut);
        tramasGenerics.put(PaymentWsConstants.TRSG, trama);
        response = PaymentsProcessGenerator.generateProcessSheduleServiceOrderResponse(tramasGenerics);
        code = Constants.TBK_RESPONSE_SUCCESS_CODE;
        message = Constants.TBK_RESPONSE_SUCCESS_MESSAGE;
        status = new Status(code, message);
        response.setStatus(status);

        return response;
    }

    public TRSGFileDetailInput[] getDetailsWithCurrency(TRSGFileDetailInput[] details, String currency)
    {
        for (int i = 0; i < details.length; i++)
        {
            details[i].setCurrency(currency);
        }

        return details;
    }

    public List<String> getFileContent(PreOrderDetailInput[] details)
    {
        List<String> lista = new ArrayList<String>();
        for (int i = 0; i < details.length; i++)
        {
            details[i].setNetId(PaymentWsConstants.TBK_TRSG_DETAIL);
            lista.add(2 * i, details[i].toString());
            details[i].setNetId(PaymentWsConstants.TBK_TRSG_NET);
            lista.add(2 * i + 1, details[i].toString());
        }
        return lista;
    }

    @Override
    public PreOrderResponse processSheduleIndividualOrder(User user, String order,
            String accountTitle, String reference, String scheduledDate, String templateNumber)
    {
        Trama tramaTROP;
        PreOrderResponse preOrderResponse = null;
        try
        {
            TROPInput trpo = new TROPInput(order, accountTitle, reference, scheduledDate, templateNumber);

            tramaTROP = GenerateTrama.createTrama(PaymentWsConstants.TROP, user, trpo);

            String input = tramaTROP.generateStringTramaToSend();
            String output = getConnectAS400().executeAS400Call(input);

            tramaTROP.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));

            /*
             * if (!tramaTROP.getHeaderOutput().isValid()) { return new PreOrderResponse(new
             * Status(tramaTROP.getHeaderOutput().getError(), output .substring(Constants.TBK_LENGHT_TRAMA,
             * Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150))); }
             */

            preOrderResponse = new PreOrderResponse();
            preOrderResponse.setReturnCode(tramaTROP.getHeaderOutput().getError());
        }
        catch (Exception e)
        {
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());

        }
        return preOrderResponse;

    }

	@Override
	public PreOrderCopyResponse getPreOrderCopyServices(User user, String order, String orderNew)
			throws TBKWebServiceGenericException {
		Trama tramaTRRO;
		String cadenaInput;
		Map<String, Trama> tramaGenerics = new HashMap<>();
		PreOrderCopyResponse response = null;
		String code;
		String message;
		Status status;

		try {
			TRROInput trro = new TRROInput(user.getContract(), order, user.getUserCode(), orderNew);

			tramaTRRO = GenerateTrama.createTrama(PaymentWsConstants.TRRO, user, trro);

			cadenaInput = tramaTRRO.generateStringTramaToSend();
			String output = getConnectAS400().executeAS400Call(cadenaInput);

			tramaTRRO.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));
			
			if (!tramaTRRO.getHeaderOutput().isValid()) {
				code = tramaTRRO.getHeaderOutput().getError();
				message = output.substring(Constants.TBK_LENGHT_TRAMA, Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150);

				if (code.equals( PaymentWsConstants.TBK_TRRO_DATA_ERROR_INVALID)) {
					status = new Status(code, PaymentWsConstants.TBK_TRRO_RESPONSE_ERROR_INVALID_DATA);
					return new PreOrderCopyResponse(status);
				} else if (code.equals(PaymentWsConstants.TBK_TRRO_DATA_ERROR_DUPLICATE_ORDER)) {
					status = new Status(code, PaymentWsConstants.TBK_TRRO_RESPONSE_ERROR_DUPLICATE_ORDER);
					return new PreOrderCopyResponse(status);
				} else if (code.equals(PaymentWsConstants.TBK_TRRO_DATA_ERROR_DUPLICATE_DETAIL)) {
					status = new Status(code, PaymentWsConstants.TBK_TRRO_DATA_ERROR_RECORD_DUPLICATE_DETAIL);
					return new PreOrderCopyResponse(status);
				}else{
					status = new Status(code, PaymentWsConstants.TBK_TRRO_RESPONSE_ERROR_DATE);
					return new PreOrderCopyResponse(status);
				}
			}

			String outputBody = output.substring(Constants.TBK_LENGHT_TRAMA, output.length());

			TRROOutput trroOutput = new TRROOutput(outputBody);
			tramaTRRO.setOutputBody(trroOutput);

			tramaGenerics.put(PaymentWsConstants.TRRO, tramaTRRO);
			response = PaymentsProcessGenerator.generatePreOrderCopyResponse(tramaGenerics);
			code = tramaTRRO.getHeaderOutput().getError();
				message = PaymentWsConstants.TBK_TRRO_RESPONSE_SUCCESS_MESSAGE_COPY;
				status = new Status(code, message);
				response.setStatus(status);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
		}
		return response;
	}

    @Override
    public ValidateAccountsResponse validateAccounts(User user, Account[] accounts, String documentType,
            String documentNumber, CTS cts)
    {
        Trama trama;
        String cadenaInput;
        Map<String, Trama> tramasGenerics = new HashMap<>();
        ValidateAccountsResponse response = null;
        try
        {
            TRVCInput trvc = new TRVCInput(accounts, documentType, documentNumber, cts);
            trama = GenerateTrama.createTrama(PaymentWsConstants.TRVC, user, trvc);
            cadenaInput = trama.generateStringTramaToSend();
            String output = getConnectAS400().executeAS400Call(cadenaInput);
            trama.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));

            String outputBody = output.substring(Constants.TBK_LENGHT_TRAMA, output.length());
            TRVCOutput trvcOutput = new TRVCOutput(outputBody);
            trama.setOutputBody(trvcOutput);
            tramasGenerics.put(PaymentWsConstants.TRVC, trama);
            response = PaymentsProcessGenerator.generateValidateAccounts(tramasGenerics);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return response;
    }

    @Override
    public Response processSheduleMassiveOrder(User user, String[] orders) throws TBKWebServiceGenericException
    {
        Trama trama;
        String cadenaInput;
        Response response = null;
        try
        {
            TRPEInput trpe = new TRPEInput(orders);
            trama = GenerateTrama.createTrama(PaymentWsConstants.TRPE, user, trpe);
            cadenaInput = trama.generateStringTramaToSend();
            String output = getConnectAS400().executeAS400Call(cadenaInput);
            trama.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));
            String code = trama.getHeaderOutput().getError();
            String message = "";
            if (!trama.getHeaderOutput().isValid())
            {
                message = output.substring(Constants.TBK_LENGHT_TRAMA, Constants.TBK_OUTPUT_INDEX_ERROR_MESSAGE_150);
            }
            else
            {
                message = Constants.TBK_RESPONSE_SUCCESS_MESSAGE;
            }
            response = new Response(code, message);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return response;
    }

    @Override
    public ProcessOrder reprocessOrder(User user, String order) throws TBKWebServiceGenericException
    {
        Trama tramaTRPN;
        String cadenaInput;
        ProcessOrder response = null;

        try
        {
            TRPNInput trpn = new TRPNInput(order);

            tramaTRPN = GenerateTrama.createTrama(PaymentWsConstants.TRPN, user, trpn);

            cadenaInput = tramaTRPN.generateStringTramaToSend();
            String output = getConnectAS400().executeAS400Call(cadenaInput);

            tramaTRPN.setHeaderOutput(new Header(output.substring(0, Constants.TBK_LENGHT_TRAMA)));

            response = new ProcessOrder();
            response.setReturnCode(tramaTRPN.getHeaderOutput().getError());

        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("Ocurrio un error al consumir el servicio: " + e.getMessage());
        }
        return response;
    }

}
