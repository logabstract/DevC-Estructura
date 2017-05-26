
package pe.com.scotia.tbk.test.service;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pe.com.scotiabank.tbk.payment.beans.Account;
import pe.com.scotiabank.tbk.payment.beans.CTS;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderDetailRequest;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderHeaderRequest;
import pe.com.scotiabank.tbk.payment.beans.PreliquidateService;
import pe.com.scotiabank.tbk.payment.beans.VerifiedAccount;
import pe.com.scotiabank.tbk.payment.response.PreOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessPreliquidateServiceResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessSheduleServiceOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateAccountsResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateOrderStructureResponse;
import pe.com.scotiabank.tbk.payment.response.ValidatePreOrderResponse;
import pe.com.scotiabank.tbk.payment.services.impl.PaymentsProcessServicesImpl;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TB2WFileInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileDetailInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileHeaderInput;
import pe.com.scotiabank.tbk.payment.util.PaymentWsConstants;
import pe.com.scotiabank.tbk.payment.webservices.impl.PaymentsProcessWebServicesImpl;
import pe.com.scotiabank.tbk.test.utils.UtilTest;
import pe.com.scotiabank.tbk.util.beans.Response;
import pe.com.scotiabank.tbk.util.beans.User;
import pe.com.scotiabank.tbk.util.dao.ConnectAS400;
import pe.com.scotiabank.tbk.util.exception.TBKWebServiceGenericException;
import pe.com.scotiabank.tbk.util.utilities.Constants;

public class PaymentsProcessServiceTest
{
    PaymentsProcessWebServicesImpl paymentsProcessWebServices;
    PaymentsProcessServicesImpl paymentsProcessServices;
    ConnectAS400 connectAS400;

    User user;

    @Before
    public void setUp()
    {
        paymentsProcessWebServices = new PaymentsProcessWebServicesImpl();
        paymentsProcessServices = new PaymentsProcessServicesImpl();

        connectAS400 = new ConnectAS400();

        paymentsProcessServices.setConnectAS400(connectAS400);
        paymentsProcessWebServices.setPaymentsProcessServices(paymentsProcessServices);
    }

    @Test
    public void validatePreOrderValidationService() throws TBKWebServiceGenericException
    {
        System.out.println("------ Ejecutando prueba de Integracion validatePreOrderValidationService-------");

        ValidatePreOrderResponse response = null;
        user = new User();
        user.setContract("0166");
        user.setUserCode("04");
        user.setSessionId("0000000");

        response = paymentsProcessServices.validatePreOrder(user, "000", "424");

        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());

        assertThat(response.getStatus().getCode(), anyOf(is(Constants.TBK_RESPONSE_SUCCESS_CODE), is("0012")));

    }

    @Test
    public void validateOrderValidationService() throws TBKWebServiceGenericException
    {
        System.out.println("------ Ejecutando prueba de Integracion validateOrderValidationService-------");

        ValOrderResponse response = null;
        user = new User();
        user.setContract("0043");
        user.setUserCode("01");
//        user.setSessionId("0000000");

        response = paymentsProcessServices.validateOrder(user, "001", "254");

        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());

        assertThat(response.getStatus().getCode(),
                anyOf(is(Constants.TBK_RESPONSE_SUCCESS_CODE), is("0185"), // La orden ya existe en Pre-Ordenes
                        is("0186"), // La orden ya existe en Ordenes Programadas
                        is("0187"))); // La orden ya existe en Ordenes Registradas

    }

    @Test
    public void testValidationOrderStructureService() throws TBKWebServiceGenericException, IOException
    {
        System.out.println(
                "------ Ejecutando prueba de Integracion testValidationOrderStructureService TREM FLAG 'S'-------");

        ValidateOrderStructureResponse response = null;

        user = new User();
        user.setContract("0166");
        user.setUserCode("01");
        // user.setSessionId("");

        response = paymentsProcessServices.validateOrderStructure(user, "001", "02729", "08", "00001", "", "", "0000",
                "3,000.00", "USUARIO 22", "21", "reference", "S", "c9f6c24b-bd7e-42f5-8844-754529ab34fb.txt", null);

        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());

        assertThat(response.getStatus().getCode(),
                anyOf(is(Constants.TBK_RESPONSE_SUCCESS_CODE), is("0185"), // La orden ya existe en Pre-Ordenes
                        is("0186"), // La orden ya existe en Ordenes Programadas
                        is("0187"))); // La orden ya existe en Ordenes Registradas

    }

    @Test
    public void testProcessOrderStructureService() throws TBKWebServiceGenericException, IOException
    {
        System.out.println(
                "------ Ejecutando prueba de Integracion testProcessOrderStructureService TREM FLAG 'N'-------");

        ArrayList<String> errorfileList = new ArrayList<>();
        errorfileList.add("    1DCuenta/Documento                                  La cuenta no coincide con eldocumento             Verificar cuenta y/o documento                    ");
        errorfileList.add("    2DCuenta/Documento                                  La cuenta no coincide con eldocumento             Verificar cuenta y/o documento                    ");

        Path p = Paths.get("C:/scotia/apps/telebanking/ftp/9c3291b0-ff14-495b-a1c7-f0283726cba0");
        Files.write(p, errorfileList, Charset.defaultCharset());

        ValidateOrderStructureResponse response = null;

        user = new User();
        user.setContract("5452");
        user.setUserCode("01");
        // user.setSessionId("");

        response = paymentsProcessServices.validateOrderStructure(user, "001", "02720", "01", "00002", "454424200001",
                "01/03/2017", "0000", "24,7989.71", "USUARIO 22", "21", "reference", "N",
                "c9f6c24b-bd7e-42f5-8844-754529ab34fb.zip", "9c3291b0-ff14-495b-a1c7-f0283726cba0");

        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());

        assertThat(response.getStatus().getCode(),
                anyOf(is(Constants.TBK_RESPONSE_SUCCESS_CODE), is("0185"), // La orden ya existe en Pre-Ordenes
                        is("0186"), // La orden ya existe en Ordenes Programadas
                        is("0187"))); // La orden ya existe en Ordenes Registradas

    }

    @Test
    public void testProcessOrderStructureServiceFlagD() throws TBKWebServiceGenericException, IOException
    {
        System.out.println(
                "------ Ejecutando prueba de Integracion testProcessOrderStructureService TREM FLAG 'D'-------");

        ArrayList<String> errorfileList = new ArrayList<>();
        errorfileList.add(
                "    5DCuenta/Documento                                  La cuenta no coincide con eldocumento             Verificar cuenta y/o documento                    ");
        errorfileList.add(
                "    6DCuenta/Documento                                  La cuenta no coincide con eldocumento             Verificar cuenta y/o documento                    ");
        errorfileList.add(
                "    7DCuenta/Documento                                  La cuenta no coincide con eldocumento             Verificar cuenta y/o documento                    ");

        Path p = Paths.get("C:/scotia/apps/telebanking/ftp/9c3291b0-ff14-495b-a1c7-f0283726cba0");
        Files.write(p, errorfileList, Charset.defaultCharset());

        ValidateOrderStructureResponse response = null;

        user = new User();
        user.setContract("4907");
        user.setUserCode("01");
        // user.setSessionId("");

        response = paymentsProcessServices.validateOrderStructure(user, "", "", "", "", "", "", "", "", "", "", "", "D",
                null, "9c3291b0-ff14-495b-a1c7-f0283726cba0");

        assertThat(response.getStatus().getCode(), anyOf(is(Constants.TBK_RESPONSE_SUCCESS_CODE), is("0185")));
        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());

        assertThat(response.getStatus().getCode(),
                anyOf(is(Constants.TBK_RESPONSE_SUCCESS_CODE), is("0185"), // La orden ya existe en Pre-Ordenes
                        is("0186"), // La orden ya existe en Ordenes Programadas
                        is("0187"))); // La orden ya existe en Ordenes Registradas
    }

    @Test
    public void validatePreOrderAdd() throws TBKWebServiceGenericException
    {
        String contract = "0043";
        String order = "5672";// 56569, 56570, 56571,56572,56573 agregado x 1era vez
        String action = "A";
        String orderType = "001";
        String sequence = "001";
        String userCode = "01";
        String currency = "0001";
        String detailUser = userCode;
        String documentType = "05";
        String documentNumber = "20164766251";
        String employeeCode = "";
        String beneficiary = "BENEF_CESITAR_2";
        String invoiceNumber = "1234567";
        String paymentUnique = "*";
        String paymentForm = "2";
        String account = "126705";
        String cci = "";
        String email = "lellmeza@gmail.com";
        String dueDate = "";
        String invoiceDate = "04/05/2017";
        String amount = "100";

        Response response = null;
        user = new User();
        user.setContract(contract);
        user.setUserCode(userCode);

        MaintainPreOrderHeaderRequest preOrderHeader = new MaintainPreOrderHeaderRequest();
        preOrderHeader.setAction(action);
        preOrderHeader.setCurrency(currency);
        preOrderHeader.setOrder(order);
        preOrderHeader.setOrderType(orderType);
        preOrderHeader.setSequence(sequence);
        MaintainPreOrderDetailRequest preOrderDetail = new MaintainPreOrderDetailRequest();
        preOrderDetail.setDetailUser(detailUser);
        preOrderDetail.setDocumentType(documentType);
        preOrderDetail.setDocumentNumber(documentNumber);
        preOrderDetail.setEmployeeCode(employeeCode);
        preOrderDetail.setBeneficiary(beneficiary);
        preOrderDetail.setDueDate(dueDate);
        preOrderDetail.setInvoiceDate(invoiceDate);
        preOrderDetail.setCci(cci);
        preOrderDetail.setEmail(email);
        preOrderDetail.setInvoiceNumber(invoiceNumber);
        preOrderDetail.setSinglePayment(paymentUnique);
        preOrderDetail.setMethodPayment(paymentForm);
        preOrderDetail.setAccount(account);
        preOrderDetail.setAmount(amount);

        response = paymentsProcessServices.savePreOrder(user, preOrderHeader, preOrderDetail);
        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());
    }

    @Test
    public void validatePreOrderModify() throws TBKWebServiceGenericException
    {
        String contract = "0043";
        String order = "56569";// 56569, 56570, 56571,56572 agregado x 1era vez
        String action = "M";
        String orderType = "001";
        String sequence = "001";
        String userCode = "02";
        String currency = "0001";
        String correlative = "000001";

        String detailUser = userCode;
        String documentType = "01";
        String documentNumber = "12345678";
        String employeeCode = "45678987";
        String beneficiary = "BENEF01";

        Response response = null;
        user = new User();
        user.setContract(contract);
        user.setUserCode(userCode);

        MaintainPreOrderHeaderRequest preOrderHeader = new MaintainPreOrderHeaderRequest();
        preOrderHeader.setAction(action);
        preOrderHeader.setCurrency(currency);
        preOrderHeader.setOrder(order);
        preOrderHeader.setOrderType(orderType);
        preOrderHeader.setSequence(sequence);
        ;
        MaintainPreOrderDetailRequest preOrderDetail = new MaintainPreOrderDetailRequest();
        preOrderDetail.setCorrelative(correlative);
        preOrderDetail.setDetailUser(detailUser);
        preOrderDetail.setDocumentType(documentType);
        preOrderDetail.setDocumentNumber(documentNumber);
        preOrderDetail.setEmployeeCode(employeeCode);
        preOrderDetail.setBeneficiary(beneficiary);

        response = paymentsProcessServices.savePreOrder(user, preOrderHeader, preOrderDetail);
        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

    }

    @Test
    public void validatePreOrderDelete() throws TBKWebServiceGenericException
    {
        String contract = "0043";
        String order = "56569";// 56569, 56570, 56571,56572 agregado x 1era vez
        String userCode = "02";
        String correlative = "000004";

        Response response = null;
        user = new User();
        user.setContract(contract);
        user.setUserCode(userCode);
        MaintainPreOrderHeaderRequest preOrderHeader = new MaintainPreOrderHeaderRequest();
        preOrderHeader.setOrder(order);
        MaintainPreOrderDetailRequest preOrderDetail = new MaintainPreOrderDetailRequest();
        preOrderDetail.setCorrelative(correlative);

        response = paymentsProcessServices.deletePreOrder(user, order, correlative);
        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

    }

    @Test
    public void validateProcessPreliquidateService() throws TBKWebServiceGenericException
    {
        System.out.println(
                "------------------ Ejecutando prueba de Integracion validateProcessPreliquidateService -------------------------");

        String contract = "0166";
        String userCode = "01";
        String sequence = "002";

        // ESTRUCTURA ARCHIVO DE ENTRADA
        String ruc = "20100113610";
        String serviceType = "101";
        String currency = "0000";
        String documentToPay = "0010246779          ";
        TB2WFileInput fileInput = new TB2WFileInput();
        fileInput.setRuc(ruc);
        fileInput.setServiceType(serviceType);
        fileInput.setCurrency(currency);
        fileInput.setDocumentToPay(documentToPay);
        TB2WFileInput[] records = new TB2WFileInput[1];
        records[0] = fileInput;
        user = new User();
        user.setContract(contract);
        user.setUserCode(userCode);
        user.setCompanySecuence(sequence);

        ProcessPreliquidateServiceResponse response = paymentsProcessServices.processPreliquidateService(user, sequence,
                records);

        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

        String sessionName = response.getSessionName();
        System.out.println("sessionName [" + sessionName + "]");
        PreliquidateService[] preLiquidation = response.getProcessPreliquidateService();

        for (PreliquidateService service : preLiquidation)
        {
            System.out.println("service [" + service + "]");
        }

    }

    @Test
    public void validateProcessSheduleServiceOrder() throws TBKWebServiceGenericException
    {
        System.out.println(
                "------------------ Ejecutando prueba de Integracion validateProcessSheduleServiceOrder -------------------------");

        String contract = "4907";
        String userCode = "01";
        String order = "1019";
        String companySequence = "001";

        user = new User();
        user.setContract(contract);
        user.setUserCode(userCode);
        user.setCompanySecuence(companySequence);
        
        TRSGFileHeaderInput header = new TRSGFileHeaderInput();
        header.setContract1(contract);
        header.setOrder(order);// 4 dig
//        header.setDate("25/05/2017");
        header.setAccountPayment("0000");
        header.setChequePayments("0001");
        header.setTotal1("411.25");
        header.setTotal2("411.25");
        header.setCurrency("92");
        header.setOffice("000");
        header.setAccountCode("4544242");
//        header.setSecurityCodeModule("76");
//        header.setSecurityCode("39");
//        header.setTime("144759");
        header.setAccountType("2");// 2 o 3
//        header.setHigherPayment("411.25");
        header.setContract2(contract);
        header.setCompanySequence(companySequence);
        header.setUser(userCode);
        header.setPaymentQuantities("0001");
        header.setReference("000000000000000");
        header.setAccountPayment2("00000");
        header.setChequePayment("00001");
        header.setUserName("USUARIO 01");

        TRSGFileDetailInput[] details = new TRSGFileDetailInput[1];
        details[0] = new TRSGFileDetailInput();

        details[0].setServiceName("EL CARMELO");
        details[0].setReceiptNumber("");
//        details[0].setDate("20170401");
        details[0].setReceiptNumber2("0003");
        details[0].setExpiryDate("20180113");
        details[0].setSupplyCode("20170410");
        details[0].setAmount("00000041125");
        details[0].setServiceType("001");
        details[0].setSecurityCode("06");
        details[0].setOffice("000");
        details[0].setAccountCode2("4544242");
        details[0].setRuc2("20140962644");

        String paymentType = "11";
        String chargeAccount = "45442420001";
        String programmeDate = "20170501";
        String reference = "000000000000000";
        String receiptTotal = "1";

        ProcessSheduleServiceOrderResponse response = paymentsProcessServices.processSheduleServiceOrder(user, order,
                paymentType, chargeAccount, programmeDate, reference, receiptTotal, header, details);
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());
    }

    // @Test
    // public void validateSecurityCodeHeader()
    // {
    // int paramsLength = 298;
    // int moduleSecurityCode;
    // double dmodulo = Math.floor(51.0 + Math.random() * 48.0);
    // moduleSecurityCode = (int) dmodulo;
    // System.out.println("viModulo [" + moduleSecurityCode + "]");
    //
    // String contract = "4907";
    // String date = "20170401";// Parece ser fecha actual
    // String order = "1019";
    // int total = 41125;
    // String weight = null;
    // String currency = "0000";
    // String paymentForm = "1";
    //
    // if (currency.equals("0000"))
    // {
    // // xRes = xRes + Functions.fStr("92", 'I', 2, '0');
    // weight = "02";
    // }
    // else
    // {
    // // xRes = xRes + Functions.fStr("01", 'I', 2, '0');
    // weight = "01";
    // }
    //
    // int accountPayment = Integer.parseInt("0000");// abonosCta
    // int chequePayments = Integer.parseInt("0001");// abonosChq
    //
    // String securityCode = CalculaCodigodeSeguridad(paramsLength, moduleSecurityCode, contract, date, order, total,
    // weight, "", "", "", accountPayment, chequePayments);
    // System.out.println("securityCode Header [" + securityCode + "]");
    //
    // securityCode = CalculaCodigodeSeguridad(0, moduleSecurityCode, contract, date, order, total, weight,
    // paymentForm, ctaGetCta(cuentaAbono), ctaGetCta(cuentaCargo), 0, 0);
    // }
    //
    // public static String CalculaCodigodeSeguridad(int numpagos, int Modulo, String Convenio, String FechaOrden,
    // String NumeroOrden, long importe11, String Peso, String FormaPago, String CtaAbono, String CtaCargo,
    // int AbonosCta, int AbonosChq)
    // {
    // String CodeSeg = "00";
    // long icodeSeg = 0;
    // if (numpagos == 0)
    // { // Detalle
    // icodeSeg = Integer.parseInt(Convenio);
    // icodeSeg += Integer.parseInt(FechaOrden.substring(2));
    // icodeSeg += Integer.parseInt(NumeroOrden);
    // icodeSeg += (importe11 / 100);
    // icodeSeg += Integer.parseInt(Peso);
    // icodeSeg += Integer.parseInt(FormaPago);
    // icodeSeg += Integer.parseInt(CtaAbono);
    // icodeSeg += Integer.parseInt(CtaCargo);
    // }
    // else
    // { // Cabecera
    // int icodeSegParcial = 0;
    // icodeSeg = Integer.parseInt(Convenio);
    // icodeSeg += Integer.parseInt(FechaOrden.substring(2));
    // icodeSeg += Integer.parseInt(NumeroOrden);
    // icodeSegParcial += Integer.parseInt(Peso);
    // icodeSegParcial += AbonosCta;
    // icodeSegParcial += AbonosChq;
    // icodeSeg = icodeSeg + icodeSegParcial * (importe11 / 100);
    // System.out.println("Cod.Seg: Suma Parcial " + icodeSegParcial);
    // }
    // System.out.println("Cod. Seg: Suma " + icodeSeg);
    // CodeSeg = "" + icodeSeg;
    // int totaldig = 0;
    // for (int k = 0; k < CodeSeg.length(); k++)
    // {
    // String digito = CodeSeg.substring(k, k + 1);
    // int dig = Integer.parseInt(digito);
    // totaldig += dig * (k + 1);
    // }
    // int res = totaldig % Modulo;
    // CodeSeg = "" + (Modulo - res);
    // System.out.println("Cod. Seg: " + CodeSeg + " -- [ Pagos:" + numpagos + " Modulo:" + Modulo + " Convenio:"
    // + Convenio + " Fecha:" + FechaOrden + " Orden:" + NumeroOrden + " Importe:" + importe11 + " Peso:"
    // + Peso + " Tipo:" + FormaPago + " CtaAbono:" + CtaAbono + " CtaCargo:" + CtaCargo + " ]");
    // return CodeSeg;
    // }
    //
    // public static String ctaGetCta(String numcta)
    // {
    // if (numcta == null)
    // return "";
    // numcta = numcta.trim();
    // String cuenta = "";
    // try
    // {
    // String sesscta = getSessionVar(numcta);
    // if (sesscta == null)
    // sesscta = getSessionVar(ctaFindCta(numcta));
    // if (sesscta != null)
    // {
    // cuenta = Functions.getTokenIndex(sesscta, 15, "|");
    // return cuenta;
    // }
    // // si no enxuentra
    // if (numcta.length() == 14)
    // cuenta = numcta.substring(5, 12);
    // else
    // cuenta = numcta.substring(0, 7);
    // }
    // catch (Exception e)
    // {
    // System.out.println(("numcta:" + numcta + " e:" + e.getMessage()));
    // }
    // return cuenta;
    // }
    //
    // public String ctaFindCta(String numcta) {
    // if (numcta==null) return "";
    // if (numcta.trim().isEmpty()) return "";
    // try {
    // StringTokenizer stxc = new StringTokenizer(getSessionVar("CTAS"), "|");
    // while (stxc.hasMoreTokens()) {
    // String cta = stxc.nextToken();
    // if ((numcta.trim().contains(cta.trim()))||
    // (cta.trim().contains(numcta.trim()))||
    // (cta.trim().equals(numcta.trim()))) {
    // return cta;
    // }
    // }
    // } catch (Exception e) {
    // logger.error("numcta:"+numcta+" e:"+e.getMessage());
    // }
    // return numcta;
    // }

    @Test
    public void validateProcessSheduleIndividualOrder() throws TBKWebServiceGenericException
    {
        System.out.println("------ Ejecutando prueba de Integracion validateProcessSheduleIndividualOrder-------");

        PreOrderResponse response = null;
        user = new User();
        user.setContract("5452");
        user.setUserCode("01");
        String order = "07109";
        String accountTitle = "1311156789";
        String reference = "reference";
        String scheduledDate = "06/05/2017";
        String templateNumber = "00001";

        response = paymentsProcessServices.processSheduleIndividualOrder(user, order, accountTitle, reference,
                scheduledDate, templateNumber);

        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());

        assertThat(response.getStatus().getCode(), anyOf(is(Constants.TBK_RESPONSE_SUCCESS_CODE), is("0012")));

    }

    @Test
    public void validateLengthAccount()
    {
        System.out.println("------ validateLengthAccount -------");

        Account[] accounts = new Account[6];

        accounts[0] = new Account();
        accounts[0].setOffice("115");
        accounts[0].setAccountCode("0178999");
        accounts[0].setAccountType("2");
        accounts[0].setCurrency("0001");

        accounts[1] = new Account();
        accounts[1].setOffice("000");
        accounts[1].setAccountCode("2381231");
        accounts[1].setAccountType("3");
        accounts[1].setCurrency("0001");

        accounts[2] = new Account();
        accounts[2].setOffice("001");
        accounts[2].setAccountCode("1020935");
        accounts[2].setAccountType("4");
        accounts[2].setCurrency("0001");

        accounts[3] = new Account();
        accounts[3].setOffice("000");
        accounts[3].setAccountCode("3054683");
        accounts[3].setAccountType("3");
        accounts[3].setCurrency("0000");

        accounts[4] = new Account();
        accounts[4].setOffice("000");
        accounts[4].setAccountCode("4336674");
        accounts[4].setAccountType("3");
        accounts[4].setCurrency("0000");

        accounts[5] = new Account();
        accounts[5].setOffice("000");
        accounts[5].setAccountCode("9101845");
        accounts[5].setAccountType("3");
        accounts[5].setCurrency("0000");

        String cad = "";
        for (int i = 0; i < accounts.length; i++)
        {
            cad = cad + accounts[i].toString();
        }
        System.out.println("cad [" + cad + "]");

        int lengthSuccess = (PaymentWsConstants.TBK_TRVC_ATTR_LENGTH_OFFICE
                + PaymentWsConstants.TBK_TRVC_ATTR_LENGTH_ACCOUNT_CODE
                + PaymentWsConstants.TBK_TRVC_ATTR_LENGTH_ACCOUNT_TYPE
                + PaymentWsConstants.TBK_TRVC_ATTR_LENGTH_CURRENCY) * accounts.length;
        Assert.assertEquals(lengthSuccess, cad.length());

    }

    @Test
    public void validateAccountsResponse() throws TBKWebServiceGenericException
    {
        System.out.println("------ validateAccountsResponse -------");
        ValidateAccountsResponse response = null;
        user = new User();
        String contract = "0043";
        String userCode = "01";
        String documentType = "5";
        String documentNumber = "201335300036";
        user.setContract(contract);
        user.setUserCode(userCode);
        user.setCompanySecuence("001");

        Account[] accounts = new Account[6];

        accounts[0] = new Account();
        accounts[0].setOffice("115");
        accounts[0].setAccountCode("0178999");
        accounts[0].setAccountType("2");
        accounts[0].setCurrency("0001");

        accounts[1] = new Account();
        accounts[1].setOffice("000");
        accounts[1].setAccountCode("2381231");
        accounts[1].setAccountType("3");
        accounts[1].setCurrency("0001");

        accounts[2] = new Account();
        accounts[2].setOffice("001");
        accounts[2].setAccountCode("1020935");
        accounts[2].setAccountType("4");
        accounts[2].setCurrency("0001");

        accounts[3] = new Account();
        accounts[3].setOffice("000");
        accounts[3].setAccountCode("3054683");
        accounts[3].setAccountType("3");
        accounts[3].setCurrency("0000");

        accounts[4] = new Account();
        accounts[4].setOffice("000");
        accounts[4].setAccountCode("4336674");
        accounts[4].setAccountType("3");
        accounts[4].setCurrency("0000");

        accounts[5] = new Account();
        accounts[5].setOffice("000");
        accounts[5].setAccountCode("9101845");
        accounts[5].setAccountType("3");
        accounts[5].setCurrency("0000");

        CTS cts = null;

        response = paymentsProcessServices.validateAccounts(user, accounts, documentType, documentNumber, cts);
        for (VerifiedAccount account : response.getVerifiedAccount())
        {
            System.out.println("account [" + account.toString() + "]");
        }
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

        System.out.println(UtilTest.processResponseObject(response));
        // CODIGO 0807 indica que por lo menos una cuenta no es valida.
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());

    }

    @Test
    public void validateProcessSheduleMassiveOrder() throws TBKWebServiceGenericException
    {
        System.out.println("------ validateProcessSheduleMassiveOrder-------");

        Response response = null;
        user = new User();
        String contract = "0043";// 0166 4634
        String userCode = "02"; // 01
        String[] orders = {"1885"}; // 00690 00000
        user.setContract(contract);
        user.setUserCode(userCode);

        response = paymentsProcessServices.processSheduleMassiveOrder(user, orders);
        System.out.println(UtilTest.processResponseObject(response));
        System.out.println(response.getStatus().getCode() + " " + response.getStatus().getMessage());
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

    }

    @Test
    public void validateReprocessOrder() throws TBKWebServiceGenericException
    {
        System.out.println("------ validatereprocessOrder-------");

        Response response = null;
        user = new User();
        String contract = "0043"; // "5555";//0166 5555
        String userCode = "01"; // 01
        user.setContract(contract);
        user.setUserCode(userCode);

        String order = "56565";

        response = paymentsProcessServices.reprocessOrder(user, order);
        System.out.println(UtilTest.processResponseObject(response));
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

    }

    @Test
    public void validatePreOrderResponse() throws TBKWebServiceGenericException
    {
        System.out.println("------ validatereprocessOrder-------");

        Response response = null;
        user = new User();
        String contract = "0043";
        String userCode = "01";
        user.setContract(contract);
        user.setUserCode(userCode);

        String order = "56565";
        String accountTitle = "";
        String reference = "";
        String scheduledDate = "";
        String templateNumber = "00001";

        response = paymentsProcessServices.processSheduleIndividualOrder(user, order, accountTitle, reference,
                scheduledDate, templateNumber);
        System.out.println(UtilTest.processResponseObject(response));
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

    }

    @Test
    public void validategetPreOrderCopyServices() throws TBKWebServiceGenericException
    {
        System.out.println("------ validategetPreOrderCopyServices-------");

        Response response = null;
        user = new User();
        String contract = "0043";
        String order = "08789";
        String userCode = "01";
        ;
        String orderNew = "18790";

        user.setContract(contract);
        user.setUserCode(userCode);

        response = paymentsProcessServices.getPreOrderCopyServices(user, order, orderNew);

        System.out.println(UtilTest.processResponseObject(response));
        Assert.assertEquals(Constants.TBK_RESPONSE_SUCCESS_CODE, response.getStatus().getCode());

    }

}
