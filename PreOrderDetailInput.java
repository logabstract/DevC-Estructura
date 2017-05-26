
package pe.com.scotiabank.tbk.payment.beans;

import org.apache.commons.lang3.StringUtils;

import pe.com.scotiabank.tbk.payment.util.PaymentWsConstants;
import pe.com.scotiabank.tbk.util.utilities.Formatters;

public class PreOrderDetailInput
{
    private String type;
    private String constant;
    private String ruc;
    private String serviceName;
    private String receiptNumber;
    private String spaces;
    private String date;
    private String receiptNumber2;
    private String expiryDate;
    private String supplyCode;
    private String nulls;
    private String amount;
    private String spaces2;
    private String spaces3;
    private String currency;
    private String paymentForm;
    private String serviceType;
    private String accountCode;
    private String securityCode;
    private String constant2;
    private String office;
    private String accountCode2;
    private String constant3;
    private String constant4;
    private String spaces4;
    private String spaces5;
    private String netId;
    private String spaces6;
    private String spaces7;
    private String ruc2;
    private String spaces8;
    private String spaces9;
    private String spaces10;
    private String spaces11;
    private String spaces12;
    private String spaces13;
    private String spaces14;

    public PreOrderDetailInput()
    {
        type = PaymentWsConstants.TBK_TRSG_DETAIL_TYPE;
        constant = PaymentWsConstants.TBK_TRSG_DETAIL_TWO_ZEROS;
        ruc = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWELVE_SPACES);
        spaces = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWO_SPACES);
        nulls = PaymentWsConstants.TBK_TRSG_DETAIL_TWO_ZEROS;
        spaces2 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_SIX_SPACES);
        spaces3 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWENTY_SPACES);
        paymentForm = PaymentWsConstants.TBK_TRSG_DETAIL_PAYMENT_FORM;
        accountCode = PaymentWsConstants.TBK_TRSG_DETAIL_ACCOUNT_CODE;
        constant2 = PaymentWsConstants.TBK_TRSG_DETAIL_CONSTANT_TWO;
        constant3 = PaymentWsConstants.TBK_TRSG_DETAIL_CONSTANT_NINE_WITH_SPACE;
        constant4 = PaymentWsConstants.TBK_TRSG_DETAIL_CONSTANT_ASTERISK;
        spaces4 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_ONE_SPACE);
        spaces5 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_SEVEN_SPACES);
        spaces6 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_SIXTEEN_SPACES);
        spaces7 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_FIFTEEN_SPACES);
        spaces8 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_ONE_SPACE);
        spaces9 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWO_SPACES);
        spaces10 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_ONE_SPACE);
        spaces11 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_EIGTH_SPACES);
        spaces12 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_THIRTY_SPACES);
        spaces13 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_THIRTY_SPACES);
        spaces14 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_FOUR_SPACES);

    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        return builder.append(type).append(constant).append(ruc).append(serviceName).append(receiptNumber)
                .append(spaces).append(date).append(receiptNumber2).append(expiryDate).append(supplyCode).append(nulls)
                .append(amount).append(spaces2).append(spaces3).append(currency).append(paymentForm).append(serviceType)
                .append(accountCode).append(securityCode).append(constant2).append(office).append(accountCode2)
                .append(constant3).append(constant4).append(spaces4).append(spaces5).append(netId).append(spaces6)
                .append(spaces7).append(ruc2).append(spaces8).append(spaces9).append(spaces10).append(spaces11)
                .append(spaces12).append(spaces13).append(spaces14).toString();
    }

    public String getType()
    {
        return type;
    }

    public void setType()
    {
        this.type = PaymentWsConstants.TBK_TRSG_DETAIL_TYPE;
    }

    public String getConstant()
    {
        return constant;
    }

    public void setConstant()
    {
        this.constant = PaymentWsConstants.TBK_TRSG_DETAIL_TWO_ZEROS;
    }

    public String getRuc()
    {
        return ruc;
    }

    public void setRuc()
    {
        this.ruc = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWELVE_SPACES);
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = Formatters.truncateRightWithSpaces(serviceName, PaymentWsConstants.TBK_TRSG_SERVICE_NAME);
    }

    public String getReceiptNumber()
    {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber)
    {
        this.receiptNumber = Formatters.truncateRightWithSpaces(receiptNumber, PaymentWsConstants.TBK_TRSG_DETAIL_SECOND_RECEIBT_NUMBER);
    }

    public String getSpaces()
    {
        return spaces;
    }

    public void setSpaces()
    {
        this.spaces = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWO_SPACES);
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = Formatters.truncateLeftWithSpaces(date, PaymentWsConstants.TBK_LENGTH_DATE);
    }

    public String getReceiptNumber2()
    {
        return receiptNumber2;
    }

    public void setReceiptNumber2(String receiptNumber2)
    {
        this.receiptNumber2 = Formatters.truncateRightWithSpaces(receiptNumber2, PaymentWsConstants.TBK_TRSG_DETAIL_FIRST_RECEIBT_NUMBER);
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = Formatters.truncateLeftWithSpaces(expiryDate, PaymentWsConstants.TBK_LENGTH_DATE);
    }

    public String getSupplyCode()
    {
        return supplyCode;
    }

    public void setSupplyCode(String supplyCode)
    {
        this.supplyCode = Formatters.truncateRightWithSpaces(supplyCode, PaymentWsConstants.TBK_TRSG_DETAIL_SUPPLY_CODE);
    }

    public String getNulls()
    {
        return nulls;
    }

    public void setNulls()
    {
        this.nulls = PaymentWsConstants.TBK_TRSG_DETAIL_TWO_ZEROS;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = Formatters.truncateLeftWithZeros(amount, PaymentWsConstants.TBK_TRSG_DETAIL_AMOUNT);
    }

    public String getSpaces2()
    {
        return spaces2;
    }

    public void setSpaces2()
    {
        this.spaces2 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_SIX_SPACES);
    }

    public String getSpaces3()
    {
        return spaces3;
    }

    public void setSpaces3()
    {
        this.spaces3 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWENTY_SPACES);
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = Formatters.truncateLeftWithZeros(currency, PaymentWsConstants.TBK_TRSG_DETAIL_LEGTH_CURRENCY);
    }

    public String getPaymentForm()
    {
        return paymentForm;
    }

    public void setPaymentForm()
    {
        this.paymentForm = PaymentWsConstants.TBK_TRSG_DETAIL_PAYMENT_FORM;
    }

    public String getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(String serviceType)
    {
        this.serviceType = Formatters.truncateRightWithZeros(serviceType, PaymentWsConstants.TBK_TRSG_DETAIL_LEGTH_SERVICE_TYPE);
    }

    public String getAccountCode()
    {
        return accountCode;
    }

    public void setAccountCode()
    {
        this.accountCode = PaymentWsConstants.TBK_TRSG_DETAIL_ACCOUNT_CODE;
    }

    public String getSecurityCode()
    {
        return securityCode;
    }

    public void setSecurityCode(String securityCode)
    {
        this.securityCode = Formatters.truncateRightWithZeros(securityCode, PaymentWsConstants.TBK_TRSG_DETAIL_LEGTH_SECURITY_CODE);
    }

    public String getConstant2()
    {
        return constant2;
    }

    public void setConstant2()
    {
        this.constant2 = PaymentWsConstants.TBK_TRSG_DETAIL_CONSTANT_TWO;
    }

    public String getOffice()
    {
        return office;
    }

    public void setOffice(String office)
    {
        this.office = Formatters.truncateLeftWithSpaces(office, PaymentWsConstants.TBK_TRSG_DETAIL_LEGTH_OFFICE);
    }

    public String getAccountCode2()
    {
        return accountCode2;
    }

    public void setAccountCode2(String accountCode2)
    {
        this.accountCode2 = Formatters.truncateRightWithZeros(accountCode2, PaymentWsConstants.TBK_TRSG_DETAIL_LEGTH_ACCOUNT_CODE);
    }

    public String getConstant3()
    {
        return constant3;
    }

    public void setConstant3()
    {
        this.constant3 = PaymentWsConstants.TBK_TRSG_DETAIL_CONSTANT_NINE_WITH_SPACE;
    }

    public String getConstant4()
    {
        return constant4;
    }

    public void setConstant4()
    {
        this.constant4 = PaymentWsConstants.TBK_TRSG_DETAIL_CONSTANT_ASTERISK;
    }

    public String getSpaces4()
    {
        return spaces4;
    }

    public void setSpaces4()
    {
        this.spaces4 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_ONE_SPACE);
    }

    public String getSpaces5()
    {
        return spaces5;
    }

    public void setSpaces5()
    {
        this.spaces5 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_SEVEN_SPACES);
    }

    public String getSpaces6()
    {
        return spaces6;
    }

    public void setSpaces6()
    {
        this.spaces6 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_SIXTEEN_SPACES);
    }

    public String getSpaces7()
    {
        return spaces7;
    }

    public void setSpaces7()
    {
        this.spaces7 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_FIFTEEN_SPACES);
    }

    public String getRuc2()
    {
        return ruc2;
    }

    public void setRuc2(String ruc2)
    {
        this.ruc2 = Formatters.truncateRightWithSpaces(ruc2, PaymentWsConstants.TBK_ATTR_LENGTH_RUC);
    }

    public String getSpaces8()
    {
        return spaces8;
    }

    public void setSpaces8()
    {
        this.spaces8 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_ONE_SPACE);
    }

    public String getSpaces9()
    {
        return spaces9;
    }

    public void setSpaces9()
    {
        this.spaces9 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_TWO_SPACES);
    }

    public String getSpaces10()
    {
        return spaces10;
    }

    public void setSpaces10()
    {
        this.spaces10 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_ONE_SPACE);
    }

    public String getSpaces11()
    {
        return spaces11;
    }

    public void setSpaces11()
    {
        this.spaces11 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_EIGTH_SPACES);
    }

    public String getSpaces12()
    {
        return spaces12;
    }

    public void setSpaces12()
    {
        this.spaces12 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_THIRTY_SPACES);
    }

    public String getSpaces13()
    {
        return spaces13;
    }

    public void setSpaces13()
    {
        this.spaces13 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_THIRTY_SPACES);
    }

    public String getSpaces14()
    {
        return spaces14;
    }

    public void setSpaces14()
    {
        this.spaces14 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_DETAIL_FOUR_SPACES);
    }

    public String getNetId()
    {
        return netId;
    }

    public void setNetId(String netId)
    {
        this.netId = netId;
    }

}
