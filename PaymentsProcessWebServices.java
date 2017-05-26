
package pe.com.scotiabank.tbk.payment.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

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
import pe.com.scotiabank.tbk.payment.tramas.file.input.TB2WFileInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileDetailInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileHeaderInput;
import pe.com.scotiabank.tbk.util.beans.Response;
import pe.com.scotiabank.tbk.util.exception.TBKWebServiceGenericException;

@WebService(name = "PaymentsProcessServicePortType", targetNamespace = "http://paymentsprocessservice.jaxws.tbk.scotiabank.com.pe")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface PaymentsProcessWebServices
{

    @WebMethod(operationName = "validatePreOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/validatePreOrder")
    public ValidatePreOrderResponse validatePreOrder(@WebParam(name = "sequence") String sequence,
            @WebParam(name = "order") String order) throws TBKWebServiceGenericException;

    @WebMethod(operationName = "validateOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/validateOrder")
    public ValOrderResponse validateOrder(@WebParam(name = "sequence") String sequence,
            @WebParam(name = "order") String order) throws TBKWebServiceGenericException;

    @WebMethod(operationName = "savePreOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/savePreOrder")
    public Response savePreOrder(
            @WebParam(name = "preOrderHeaderRequest") MaintainPreOrderHeaderRequest preOrderHeaderRequest,
            @WebParam(name = "preOrderDetailRequest") MaintainPreOrderDetailRequest preOrderDetailRequest)
            throws TBKWebServiceGenericException;

    @WebMethod(operationName = "validateOrderStructure", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/validateOrderStructure")
    public ValidateOrderStructureResponse validateOrderStructure(@WebParam(name = "sequence") String sequence,
            @WebParam(name = "order") String order, @WebParam(name = "paymentType") String paymentType,
            @WebParam(name = "template") String template, @WebParam(name = "chargeAccount") String chargeAccount,
            @WebParam(name = "processDate") String processDate,
            @WebParam(name = "chargeCurrency") String chargeCurrency,
            @WebParam(name = "chargeAmount") String chargeAmount, @WebParam(name = "userName") String userName,
            @WebParam(name = "recordCount") String recordCount, @WebParam(name = "reference") String reference,
            @WebParam(name = "flagIndicator") String flagIndicator,
            @WebParam(name = "uuidUploadFile") String uuidUploadFile,
            @WebParam(name = "uuidDownloadFile") String uuidDownloadFile) throws TBKWebServiceGenericException;

    @WebMethod(operationName = "deletePreOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/deletePreOrder")
    public Response deletePreOrder(@WebParam(name = "order") String order,
            @WebParam(name = "correlative") String correlative) throws TBKWebServiceGenericException;

    @WebMethod(operationName = "processPreliquidateService", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/deletePreOrder")
    public ProcessPreliquidateServiceResponse processPreliquidateService(@WebParam(name = "sequence") String sequence,
            @WebParam(name = "record") TB2WFileInput[] fileInput) throws TBKWebServiceGenericException;

    @WebMethod(operationName = "processSheduleServiceOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/processSheduleServiceOrder")
    public ProcessSheduleServiceOrderResponse processSheduleServiceOrder(@WebParam(name = "order") String order,
            @WebParam(name = "paymentType") String paymentType, @WebParam(name = "chargeAccount") String chargeAccount,
            @WebParam(name = "programmeDate") String programmeDate, @WebParam(name = "reference") String reference,
            @WebParam(name = "receibtTotal") String receibtTotal,
            @WebParam(name = "fileHeader") TRSGFileHeaderInput fileHeader,
            @WebParam(name = "fileDetail") TRSGFileDetailInput[] fileDetail) throws TBKWebServiceGenericException;

    @WebMethod(operationName = "processSheduleIndividualOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/processSheduleIndividualOrder")
    public PreOrderResponse processSheduleIndividualOrder(@WebParam(name = "order") String order, @WebParam(name = "accountTitle") String accountTitle,
            @WebParam(name = "reference") String reference, @WebParam(name = "scheduledDate") String scheduledDate, @WebParam(name = "templateNumber") String templateNumber)
            throws TBKWebServiceGenericException;

    @WebMethod(operationName = "getPreOrderCopyServices", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/getPreOrderCopyServices")
    public PreOrderCopyResponse getPreOrderCopyServices(@WebParam(name = "order") String order,
            @WebParam(name = "orderNew") String orderNew) throws TBKWebServiceGenericException;

    @WebMethod(operationName = "validateAccounts", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/validateAccounts")
    public ValidateAccountsResponse validateAccounts(@WebParam(name = "account") Account[] accounts,
            @WebParam(name = "documentType") String documentType,
            @WebParam(name = "documentNumber") String documentNumber, @WebParam(name = "cts") CTS cts)
            throws TBKWebServiceGenericException;

    @WebMethod(operationName = "processSheduleMassiveOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/processSheduleMassiveOrder")
    public Response processSheduleMassiveOrder(@WebParam(name = "order") String[] order)
            throws TBKWebServiceGenericException;

    @WebMethod(operationName = "reprocessOrder", action = "https://tbk.scotiabank.com.pe/tbk-pagos-services/reprocessOrder")
    public ProcessOrder reprocessOrder(@WebParam(name = "order") String order) throws TBKWebServiceGenericException;

}
