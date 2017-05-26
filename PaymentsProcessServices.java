
package pe.com.scotiabank.tbk.payment.services;

import pe.com.scotiabank.tbk.payment.beans.Account;
import pe.com.scotiabank.tbk.payment.beans.CTS;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderDetailRequest;
import pe.com.scotiabank.tbk.payment.beans.MaintainPreOrderHeaderRequest;
import pe.com.scotiabank.tbk.payment.response.PreOrderCopyResponse;
import pe.com.scotiabank.tbk.payment.response.PreOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessOrder;
import pe.com.scotiabank.tbk.payment.response.ProcessPreliquidateServiceResponse;
import pe.com.scotiabank.tbk.payment.response.ProcessSheduleServiceOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValOrderResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateAccountsResponse;
import pe.com.scotiabank.tbk.payment.response.ValidateOrderStructureResponse;
import pe.com.scotiabank.tbk.payment.response.ValidatePreOrderResponse;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TB2WFileInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileDetailInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileHeaderInput;
import pe.com.scotiabank.tbk.util.beans.Response;
import pe.com.scotiabank.tbk.util.beans.User;
import pe.com.scotiabank.tbk.util.exception.TBKWebServiceGenericException;

public interface PaymentsProcessServices
{
    public ValidatePreOrderResponse validatePreOrder(User user, String sequence, String order)
            throws TBKWebServiceGenericException;

    public ValOrderResponse validateOrder(User user, String sequence, String order)
            throws TBKWebServiceGenericException;

    public Response savePreOrder(User user, MaintainPreOrderHeaderRequest preOrderHeader,
            MaintainPreOrderDetailRequest preOrderDetail) throws TBKWebServiceGenericException;

    public Response deletePreOrder(User user, String order, String correlative) throws TBKWebServiceGenericException;

    public ProcessPreliquidateServiceResponse processPreliquidateService(User user, String sequence,
            TB2WFileInput[] fileInput) throws TBKWebServiceGenericException;

    public ValidateOrderStructureResponse validateOrderStructure(User user, String sequence, String order,
            String paymentType, String template, String chargeAccount, String processDate, String chargeCurrency,
            String chargeAmount, String userName, String recordCount, String reference, String flagIndicator,
            String uuidUploadFile, String uuidDownloadFile) throws TBKWebServiceGenericException;

    public ProcessSheduleServiceOrderResponse processSheduleServiceOrder(User user, String order, String paymentType,
            String chargeAccount, String programmeDate, String reference, String receibtTotal,
            TRSGFileHeaderInput header, TRSGFileDetailInput[] detail) throws TBKWebServiceGenericException;

    public PreOrderResponse processSheduleIndividualOrder(User user, String order,
            String accountTitle, String reference, String scheduledDate, String templateNumber) throws TBKWebServiceGenericException;

    public PreOrderCopyResponse getPreOrderCopyServices(User user, String order, String orderNew)
            throws TBKWebServiceGenericException;

    public ValidateAccountsResponse validateAccounts(User user, Account[] accounts, String documentType,
            String documentNumber, CTS cts) throws TBKWebServiceGenericException;

    public Response processSheduleMassiveOrder(User user, String[] orders) throws TBKWebServiceGenericException;

    public ProcessOrder reprocessOrder(User user, String order) throws TBKWebServiceGenericException;

}
