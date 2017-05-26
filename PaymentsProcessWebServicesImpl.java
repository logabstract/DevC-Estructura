
package pe.com.scotiabank.tbk.payment.webservices.impl;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import pe.com.scotiabank.tbk.payment.beans.Account;
import pe.com.scotiabank.tbk.payment.beans.CTS;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderDetailRequest;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderHeaderRequest;
import pe.com.scotiabank.tbk.payment.response.PreOrderCopyResponse;
import pe.com.scotiabank.tbk.payment.response.PreOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessOrder;
import pe.com.scotiabank.tbk.payment.response.ProcessPreliquidateServiceResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessSheduleServiceOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateAccountsResponse;
import pe.com.scotiabank.tbk.payment.response.ValOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateOrderStructureResponse;
import pe.com.scotiabank.tbk.payment.response.ValidatePreOrderResponse;
import pe.com.scotiabank.tbk.payment.services.PaymentsProcessServices;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TB2WFileInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileDetailInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileHeaderInput;
import pe.com.scotiabank.tbk.payment.webservices.PaymentsProcessWebServices;
import pe.com.scotiabank.tbk.util.beans.Response;
import pe.com.scotiabank.tbk.util.exception.ExceptionMessage;
import pe.com.scotiabank.tbk.util.exception.TBKWebServiceGenericException;
import pe.com.scotiabank.tbk.util.service.BaseWebService;
import pe.com.scotiabank.tbk.util.utilities.Constants;

@WebService(endpointInterface = "pe.com.scotiabank.tbk.payment.webservices.PaymentsProcessWebServices", portName = "PaymentsProcessServicePort", serviceName = "PaymentsProcessService", targetNamespace = "http://paymentsprocessservice.jaxws.tbk.scotiabank.com.pe")
@HandlerChain(file = "handlers.xml")
public class PaymentsProcessWebServicesImpl extends BaseWebService implements PaymentsProcessWebServices
{

    PaymentsProcessServices paymentsProcessServices;

    public PaymentsProcessServices getPaymentsProcessServices()
    {
        return paymentsProcessServices;
    }

    public void setPaymentsProcessServices(PaymentsProcessServices paymentsProcessServices)
    {
        this.paymentsProcessServices = paymentsProcessServices;
    }

    @Override
    public ValidatePreOrderResponse validatePreOrder(String sequence, String order) throws TBKWebServiceGenericException
    {

        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }

        return getPaymentsProcessServices().validatePreOrder(getUser(), sequence, order);
    }

    @Override
    public ValOrderResponse validateOrder(String sequence, String order) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }

        return getPaymentsProcessServices().validateOrder(getUser(), sequence, order);
    }

    @Override
    public ValidateOrderStructureResponse validateOrderStructure(String sequence, String order, String paymentType,
            String template, String chargeAccount, String processDate, String chargeCurrency, String chargeAmount,
            String userName, String recordCount, String reference, String flagIndicator, String uuidUploadFile,
            String uuidDownloadFile) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }
        return getPaymentsProcessServices().validateOrderStructure(getUser(), sequence, order, paymentType, template,
                chargeAccount, processDate, chargeCurrency, chargeAmount, userName, recordCount, reference,
                flagIndicator, uuidUploadFile, uuidDownloadFile);

    }

    public Response savePreOrder(MaintainPreOrderHeaderRequest preOrderHeaderRequest,
            MaintainPreOrderDetailRequest preOrderDetailRequest) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }

        return getPaymentsProcessServices().savePreOrder(getUser(), preOrderHeaderRequest, preOrderDetailRequest);
    }

    @Override
    public Response deletePreOrder(String order, String correlative) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }
        return getPaymentsProcessServices().deletePreOrder(getUser(), order, correlative);
    }

    @Override
    public ProcessPreliquidateServiceResponse processPreliquidateService(String sequence, TB2WFileInput[] fileInput)
            throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }
        return getPaymentsProcessServices().processPreliquidateService(getUser(), sequence, fileInput);
    }

    @Override
    public ProcessSheduleServiceOrderResponse processSheduleServiceOrder(String order, String paymentType,
            String chargeAccount, String programmeDate, String reference, String receibtTotal,
            TRSGFileHeaderInput fileHeader, TRSGFileDetailInput[] fileDetail) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }

        return getPaymentsProcessServices().processSheduleServiceOrder(getUser(), order, paymentType, chargeAccount,
                programmeDate, reference, receibtTotal, fileHeader, fileDetail);
    }

    @Override
    public PreOrderResponse processSheduleIndividualOrder(String order, String accountTitle,
            String reference, String scheduledDate, String templateNumber) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }

        return getPaymentsProcessServices().processSheduleIndividualOrder(getUser(), order, accountTitle,
                reference, scheduledDate, templateNumber);
    }

    @Override
    public PreOrderCopyResponse getPreOrderCopyServices(String order, String orderNew)
            throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));

        }
        return getPaymentsProcessServices().getPreOrderCopyServices(getUser(), order, orderNew);
    }

    @Override
    public ValidateAccountsResponse validateAccounts(Account[] accounts, String documentType, String documentNumber,
            CTS cts) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }

        return getPaymentsProcessServices().validateAccounts(getUser(), accounts, documentType, documentNumber, cts);
    }

    @Override
    public Response processSheduleMassiveOrder(String[] orders) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }
        return getPaymentsProcessServices().processSheduleMassiveOrder(getUser(), orders);
    }

    @Override
    public ProcessOrder reprocessOrder(String order) throws TBKWebServiceGenericException
    {
        if (!isAuthenticated())
        {
            throw new TBKWebServiceGenericException(Constants.TBK_RESPONSE_ERROR_MESSAGE, new ExceptionMessage(
                    Constants.TBK_RESPONSE_ERROR_IS_NOT_AUTENTICATE_MESSAGE, Constants.TBK_RESPONSE_ERROR_CODE));
        }
        return getPaymentsProcessServices().reprocessOrder(getUser(), order);
    }
}
