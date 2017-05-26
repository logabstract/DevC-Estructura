
package pe.com.scotiabank.tbk.payment.tramas.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import pe.com.scotiabank.tbk.payment.beans.PreOrderDetailInput;
import pe.com.scotiabank.tbk.payment.beans.PreOrderHeaderInput;
import pe.com.scotiabank.tbk.payment.response.ProcessSheduleServiceOrderResponse;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileDetailInput;
import pe.com.scotiabank.tbk.payment.tramas.file.input.TRSGFileHeaderInput;
import pe.com.scotiabank.tbk.payment.tramas.output.TRSGOutput;
import pe.com.scotiabank.tbk.util.utilities.Functions;

public class TRSGConverter
{
    public static Logger log = LoggerFactory.getLogger(TRSGConverter.class);
    
    

    public static class ConverterOutputToProcessSheduleServiceOrderResponse
            implements Converter<TRSGOutput, ProcessSheduleServiceOrderResponse>
    {

        @Override
        public ProcessSheduleServiceOrderResponse convert(TRSGOutput source)
        {
            ProcessSheduleServiceOrderResponse response = new ProcessSheduleServiceOrderResponse();
            response.setOrder(source.getOrder().trim());            
            return response;
        }

    }

    public static class ConverterTRSGFileHeaderInputToPreOrderHeaderInput
            implements Converter<TRSGFileHeaderInput, PreOrderHeaderInput>
    {
        
        Date now = new Date();
        String strDate = Functions.getCurrentTime(now, new SimpleDateFormat("YYYYMMdd"));
        String strTime = Functions.getCurrentTime(now, new SimpleDateFormat("HHmmss"));
        
        @Override
        public PreOrderHeaderInput convert(TRSGFileHeaderInput source)
        {
            PreOrderHeaderInput preOrderHeaderInput = new PreOrderHeaderInput();
            
            preOrderHeaderInput.setContract1(source.getContract1());
            preOrderHeaderInput.setOrder(source.getOrder());
            preOrderHeaderInput.setDate(strDate);
            preOrderHeaderInput.setAccountPayment(source.getAccountPayment());
            preOrderHeaderInput.setChequePayments(source.getChequePayments());
            preOrderHeaderInput.setTotal1(source.getTotal1());
            preOrderHeaderInput.setTotal2(source.getTotal2());
            preOrderHeaderInput.setCurrency(source.getCurrency());
            preOrderHeaderInput.setOffice(source.getOffice());
            preOrderHeaderInput.setAccountCode(source.getAccountCode());
            
            

//            preOrderHeaderInput.setSecurityCodeModule(source.getSecurityCodeModule());
            
            
            
            
//            preOrderHeaderInput.setSecurityCode(source.getSecurityCode());
            
            
            
            
            preOrderHeaderInput.setTime(strTime);
            preOrderHeaderInput.setAccountType(source.getAccountType());
            preOrderHeaderInput.setHigherPayment(source.getHigherPayment());
            preOrderHeaderInput.setContract2(source.getContract2());
            preOrderHeaderInput.setCompanySequence(source.getCompanySequence());
            preOrderHeaderInput.setUser(source.getUser());
            preOrderHeaderInput.setPaymentQuantities(source.getPaymentQuantities());
            preOrderHeaderInput.setReference(source.getReference());
            preOrderHeaderInput.setAccountPayment2(source.getAccountPayment2());
            preOrderHeaderInput.setChequePayment(source.getChequePayment());
            preOrderHeaderInput.setUserName(source.getUserName());
            return preOrderHeaderInput;
        }

    }

    public static class ConverterTRSGFileDetailInputToPreOrderDetailInput
            implements Converter<TRSGFileDetailInput[], PreOrderDetailInput[]>
    {
        
        Date now = new Date();
        String strDate = Functions.getCurrentTime(now, new SimpleDateFormat("YYYYMMdd"));

        @Override
        public PreOrderDetailInput[] convert(TRSGFileDetailInput[] source)
        {
            PreOrderDetailInput[] preOrderDetailInput = new PreOrderDetailInput[source.length];

            for (int i = 0; i < preOrderDetailInput.length; i++)
            {
                preOrderDetailInput[i] = new PreOrderDetailInput();
                preOrderDetailInput[i].setServiceName(source[i].getServiceName());
                preOrderDetailInput[i].setReceiptNumber(source[i].getReceiptNumber());
                preOrderDetailInput[i].setDate(strDate);
                preOrderDetailInput[i].setReceiptNumber2(source[i].getReceiptNumber2());
                preOrderDetailInput[i].setExpiryDate(source[i].getExpiryDate());
                preOrderDetailInput[i].setSupplyCode(source[i].getSupplyCode());
                preOrderDetailInput[i].setAmount(source[i].getAmount());
                preOrderDetailInput[i].setCurrency(source[i].getCurrency());
                preOrderDetailInput[i].setServiceType(source[i].getServiceType());
                preOrderDetailInput[i].setSecurityCode(source[i].getSecurityCode());
                preOrderDetailInput[i].setOffice(source[i].getOffice());
                preOrderDetailInput[i].setAccountCode2(source[i].getAccountCode2());
                preOrderDetailInput[i].setRuc2(source[i].getRuc2());
            }

            return preOrderDetailInput;
        }

    }

}
