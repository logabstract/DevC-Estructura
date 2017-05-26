
package pe.com.scotiabank.tbk.payment.tramas.input;

import org.apache.commons.lang3.StringUtils;

import pe.com.scotiabank.tbk.payment.util.PaymentWsConstants;
import pe.com.scotiabank.tbk.util.trama.Body;

public class TRSGInput implements Body
{
    private String order;
    private String paymentType;
    private String member;
    private String invoke;
    private String chargeAccount;
    private String programmeDate;
    private String reference;
    private String receiptTotal;

    public TRSGInput()
    {

    }

    public TRSGInput(String order, String paymentType, String chargeAccount, String programmeDate, String reference,
            String receiptTotal)
    {
        this.order = (order == null || order.isEmpty())
                ? StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR, PaymentWsConstants.TBK_TRSG_LENGTH_ORDER)
                : StringUtils.leftPad(order, PaymentWsConstants.TBK_TRSG_LENGTH_ORDER,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
                
        this.paymentType = (paymentType == null || paymentType.isEmpty())
                ? StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                        PaymentWsConstants.TBK_TRSG_LENGTH_PAYMENT_TYPE)
                : StringUtils.leftPad(paymentType, PaymentWsConstants.TBK_TRSG_LENGTH_PAYMENT_TYPE,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
        this.invoke = PaymentWsConstants.TBK_TRSG_INVOKE;
        this.chargeAccount = (chargeAccount == null || chargeAccount.isEmpty())
                ? StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                        PaymentWsConstants.TBK_TRSG_LENGTH_CHARGE_ACCOUNT)
                : StringUtils.leftPad(chargeAccount, PaymentWsConstants.TBK_TRSG_LENGTH_CHARGE_ACCOUNT,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
        this.programmeDate = (programmeDate == null || programmeDate.isEmpty())
                ? StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR, PaymentWsConstants.TBK_LENGTH_DATE)
                : StringUtils.leftPad(programmeDate, PaymentWsConstants.TBK_LENGTH_DATE,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
        this.reference = (reference == null || reference.isEmpty())
                ? StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                        PaymentWsConstants.TBK_TRSG_LENGTH_REFERENCE)
                : StringUtils.leftPad(reference, PaymentWsConstants.TBK_TRSG_LENGTH_REFERENCE,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
        this.receiptTotal = (receiptTotal == null || receiptTotal.isEmpty())
                ? StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                        PaymentWsConstants.TBK_TRSG_LENGTH_RECEIPT_TOTAL)
                : StringUtils.leftPad(receiptTotal, PaymentWsConstants.TBK_TRSG_LENGTH_RECEIPT_TOTAL,
                        PaymentWsConstants.CONSTANT_ZERO_CHAR);
    }

    @Override
    public void setStringBody(String output)
    {

    }

    @Override
    public String getStringBody()
    {
        return new StringBuilder().append(order).append(paymentType).append(member).append(invoke).append(chargeAccount)
                .append(programmeDate).append(reference).append(receiptTotal).toString();
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

    public String getPaymentType()
    {
        return paymentType;
    }

    public void setPaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

    public String getMember()
    {
        return member;
    }

    // public void setMember(String member)
    // {
    // this.member = member;
    // }

    public void setMember(String contract)
    {
        this.member = PaymentWsConstants.TBK_TRSG_PREFIX_MEMBER + contract + order;// S+CONVENIO(4)+ORDEN(5)
    }

    public String getInvoke()
    {
        return invoke;
    }

    public void setInvoke(String invoke)
    {
        this.invoke = invoke;
    }

    public String getChargeAccount()
    {
        return chargeAccount;
    }

    public void setChargeAccount(String chargeAccount)
    {
        this.chargeAccount = chargeAccount;
    }

    public String getProgrammeDate()
    {
        return programmeDate;
    }

    public void setProgrammeDate(String programmeDate)
    {
        this.programmeDate = programmeDate;
    }

    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = reference;
    }

    public String getReceiptTotal()
    {
        return receiptTotal;
    }

    public void setReceiptTotal(String receiptTotal)
    {
        this.receiptTotal = receiptTotal;
    }

}
