
package pe.com.scotiabank.tbk.payment.beans;

import org.apache.commons.lang3.StringUtils;

import pe.com.scotiabank.tbk.payment.util.PaymentWsConstants;
import pe.com.scotiabank.tbk.util.utilities.Formatters;

public class PreOrderHeaderInput
{
    private String contract1;
    private String order;
    private String date;
    private String accountPayment;
    private String zeros;
    private String chequePayments;
    private String total1;
    private String total2;
    private String currency;
    private String office;
    private String accountCode;
    private String securityCodeModule;
    private String securityCode;
    private String time;
    private String type;
    private String accountType;
    private String zeros2;
    private String higherPayment;
    private String spaces;
    private String zeros3;
    private String zeros4;
    private String zeros5;
    private String contract2;
    private String companySequence;
    private String user;
    private String code;
    private String paymentQuantities;
    private String reference;
    private String spaces2;
    private String spaces3;
    private String spaces4;
    private String zeros6;
    private String zeros7;
    private String zeros8;
    private String zeros9;
    private String zeros10;
    private String accountPayment2;
    private String chequePayment;
    private String spaces5;
    private String userName;
    private String spaces6;
    private String spaces7;
    private String spaces8;

    public PreOrderHeaderInput()
    {
        zeros = PaymentWsConstants.TBK_TRSG_HEADER_ELEVEN_ZEROS;
        type = PaymentWsConstants.TBK_TRSG_HEADER_TYPE;
        zeros2 = PaymentWsConstants.TBK_TRSG_HEADER_ONE_ZERO;
        spaces = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_ELEVEN_SPACES);
        zeros3 = PaymentWsConstants.TBK_TRSG_HEADER_ONE_ZERO;
        zeros4 = PaymentWsConstants.TBK_TRSG_HEADER_TWO_ZEROS;
        zeros5 = PaymentWsConstants.TBK_TRSG_HEADER_TWO_ZEROS;
        code = PaymentWsConstants.TBK_TRSG_HEADER_CODE;
        spaces2 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_FIFTEEN_SPACES);
        spaces3 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_ONE_SPACE);
        spaces4 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_TWENTY_ONE_SPACES);
        zeros6 = PaymentWsConstants.TBK_TRSG_HEADER_TWELVE_ZEROS;
        zeros7 = PaymentWsConstants.TBK_TRSG_HEADER_TWELVE_ZEROS;
        zeros8 = PaymentWsConstants.TBK_TRSG_HEADER_TWO_ZEROS;
        zeros9 = PaymentWsConstants.TBK_TRSG_HEADER_ZERO_WITH_SPACE;
        zeros10 = PaymentWsConstants.TBK_TRSG_HEADER_FIVE_ZEROS;
        spaces5 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_EIGHT_SPACES);
        spaces6 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_TWENTY_SPACES);
        spaces7 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_TWENTY_SPACES);
        spaces8 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_EIGHT_SPACES);
    }

    public String getContract1()
    {
        return contract1;
    }

    public void setContract1(String contract1)
    {
        this.contract1 = Formatters.truncateLeftWithZeros(contract1, PaymentWsConstants.TBK_TRSG_LENGTH_CONTRACT_HEADER);
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = Formatters.truncateLeftWithZeros(order, PaymentWsConstants.TBK_TRSG_LENGTH_ORDER_HEADER);
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = Formatters.truncateLeftWithSpaces(date, PaymentWsConstants.TBK_LENGTH_DATE);
    }

    public String getAccountPayment()
    {
        return accountPayment;
    }

    public void setAccountPayment(String accountPayment)
    {
        this.accountPayment = Formatters.truncateRightWithSpaces(accountPayment, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_ACCOUNT_PAYMENT);
    }

    public String getZeros()
    {
        return zeros;
    }

    public void setZeros()
    {
        this.zeros = PaymentWsConstants.TBK_TRSG_HEADER_ELEVEN_ZEROS;
    }

    public String getChequePayments()
    {
        return chequePayments;
    }

    public void setChequePayments(String chequePayments)
    {
        this.chequePayments = Formatters.truncateLeftWithZeros(chequePayments, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_CHEQUE_PAYMENT);
    }

    public String getTotal1()
    {
        return total1;
    }

    public void setTotal1(String total1)
    {
        this.total1 = Formatters.truncateLeftWithZeros(total1, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_TOTAL);
    }

    public String getTotal2()
    {
        return total2;
    }

    public void setTotal2(String total2)
    {
        this.total2 = Formatters.truncateLeftWithZeros(total2, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_TOTAL);
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = Formatters.truncateRightWithSpaces(currency, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_CURRENCY);
    }

    public String getOffice()
    {
        return office;
    }

    public void setOffice(String office)
    {
        this.office = Formatters.truncateLeftWithZeros(office, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_OFFICE);
    }

    public String getAccountCode()
    {
        return accountCode;
    }

    public void setAccountCode(String accountCode)
    {
        this.accountCode = Formatters.truncateRightWithSpaces(accountCode, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_CODE_ACCOUNT);
    }
    
    public String getSecurityCodeModule()
    {
        return securityCodeModule;
    }

    public void setSecurityCodeModule(String segurityCodeModule)
    {
        this.securityCodeModule = Formatters.truncateRightWithSpaces(segurityCodeModule, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_SECURITY_CODE_MODULE);
    }

    public String getSecurityCode()
    {
        return securityCode;
    }

    public void setSecurityCode(String segurityCode)
    {
        this.securityCode = Formatters.truncateLeftWithZeros(segurityCode, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_SECURITY_CODE);
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = Formatters.truncateRightWithSpaces(time, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_TIME);
    }

    public String getType()
    {
        return type;
    }

    public void setType()
    {
        this.type = PaymentWsConstants.TBK_TRSG_HEADER_TYPE;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = Formatters.truncateRightWithSpaces(accountType, PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_ACCOUNT_TYPE);
    }

    public String getZeros2()
    {
        return zeros2;
    }

    public void setZeros2()
    {
        this.zeros2 = PaymentWsConstants.TBK_TRSG_HEADER_ONE_ZERO;
    }

    public String getHigherPayment()
    {
        return higherPayment;
    }

    public void setHigherPayment(String higherPayment)
    {
        this.higherPayment = Formatters.truncateRightWithSpaces(higherPayment, PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_HIGHER_PAYMENT);
    }

    public String getSpaces()
    {
        return spaces;
    }

    public void setSpaces()
    {
        this.spaces = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_ELEVEN_SPACES);
    }

    public String getZeros3()
    {
        return zeros3;
    }

    public void setZeros3()
    {
        this.zeros3 = PaymentWsConstants.TBK_TRSG_HEADER_ONE_ZERO;
    }

    public String getZeros4()
    {
        return zeros4;
    }

    public void setZeros4()
    {
        this.zeros4 = PaymentWsConstants.TBK_TRSG_HEADER_TWO_ZEROS;
    }

    public String getZeros5()
    {
        return zeros5;
    }

    public void setZeros5()
    {
        this.zeros5 = PaymentWsConstants.TBK_TRSG_HEADER_TWO_ZEROS;
    }

    public String getContract2()
    {
        return contract2;
    }

    public void setContract2(String contract2)
    {
        this.contract2 = Formatters.truncateLeftWithZeros(contract2, PaymentWsConstants.TBK_TRSG_LENGTH_CONTRACT_HEADER);
    }

    public String getCompanySequence()
    {
        return companySequence;
    }

    public void setCompanySequence(String companySequence)
    {
        this.companySequence = Formatters.truncateLeftWithZeros(companySequence, PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_COMPANY_SEQUENCE);
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = Formatters.truncateLeftWithZeros(user, PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_USER);
    }

    public String getCode()
    {
        return code;
    }

    public void setCode()
    {
        this.code = PaymentWsConstants.TBK_TRSG_HEADER_CODE;
    }

    public String getPaymentQuantities()
    {
        return paymentQuantities;
    }

    public void setPaymentQuantities(String paymentQuantities)
    {
        this.paymentQuantities = Formatters.truncateLeftWithZeros(paymentQuantities, PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_PAYMENTS_QUANTITY);
    }

    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = Formatters.truncateRightWithSpaces(reference, PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_REFERENCE);
    }

    public String getSpaces2()
    {
        return spaces2;
    }

    public void setSpaces2()
    {
        this.spaces2 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_FIFTEEN_SPACES);
    }

    public String getSpaces3()
    {
        return spaces3;
    }

    public void setSpaces3()
    {
        this.spaces3 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_ONE_SPACE);
    }

    public String getSpaces4()
    {
        return spaces4;
    }

    public void setSpaces4()
    {
        this.spaces4 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_TWENTY_ONE_SPACES);
    }

    public String getZeros6()
    {
        return zeros6;
    }

    public void setZeros6()
    {
        this.zeros6 = PaymentWsConstants.TBK_TRSG_HEADER_TWELVE_ZEROS;
    }

    public String getZeros7()
    {
        return zeros7;
    }

    public void setZeros7()
    {
        this.zeros7 = PaymentWsConstants.TBK_TRSG_HEADER_TWELVE_ZEROS;
    }

    public String getZeros8()
    {
        return zeros8;
    }

    public void setZeros8()
    {
        this.zeros8 = PaymentWsConstants.TBK_TRSG_HEADER_TWO_ZEROS;
    }

    public String getZeros9()
    {
        return zeros9;
    }

    public void setZeros9(String zeros9)
    {
        this.zeros9 = PaymentWsConstants.TBK_TRSG_HEADER_ZERO_WITH_SPACE;
    }

    public String getZeros10()
    {
        return zeros10;
    }

    public void setZeros10()
    {
        this.zeros10 = PaymentWsConstants.TBK_TRSG_HEADER_FIVE_ZEROS;
    }

    public String getAccountPayment2()
    {
        return accountPayment2;
    }

    public void setAccountPayment2(String accountPayment2)
    {
        this.accountPayment2 = Formatters.truncateRightWithSpaces(accountPayment2, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_ACCOUNT_PAYMENT_2);
    }

    public String getChequePayment()
    {
        return chequePayment;
    }

    public void setChequePayment(String chequePayment)
    {
        this.chequePayment = Formatters.truncateRightWithZeros(chequePayment, PaymentWsConstants.TBK_TRSG_HEADER_LENGTH_CHEQUE_PAYMENT_2);
    }

    public String getSpaces5()
    {
        return spaces5;
    }

    public void setSpaces5()
    {
        this.spaces5 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_EIGHT_SPACES);
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = Formatters.truncateRightWithSpaces(userName, PaymentWsConstants.TBK_TRSG_HEADER_LEGTH_USER_NAME);
    }

    public String getSpaces6()
    {
        return spaces6;
    }

    public void setSpaces6()
    {
        this.spaces6 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_TWENTY_SPACES);
    }

    public String getSpaces7()
    {
        return spaces7;
    }

    public void setSpaces7()
    {
        this.spaces7 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_TWENTY_SPACES);
    }

    public String getSpaces8()
    {
        return spaces8;
    }

    public void setSpaces8(String spaces8)
    {
        this.spaces8 = StringUtils.repeat(PaymentWsConstants.CONSTANT_SPACE_CHAR,
                PaymentWsConstants.TBK_TRSG_HEADER_EIGHT_SPACES);
    }

    public String toString()
    {
        return new StringBuilder().append(contract1).append(order).append(date).append(accountPayment).append(zeros)
                .append(chequePayments).append(total1).append(total2).append(currency).append(office)
                .append(accountCode).append(securityCodeModule).append(securityCode).append(time).append(type)
                .append(accountType).append(zeros2).append(higherPayment).append(spaces).append(zeros3).append(zeros4)
                .append(zeros5).append(contract2).append(companySequence).append(user).append(code)
                .append(paymentQuantities).append(reference).append(spaces2).append(spaces3).append(spaces4)
                .append(zeros6).append(zeros7).append(zeros8).append(zeros9).append(zeros10).append(accountPayment2)
                .append(chequePayment).append(spaces5).append(userName).append(spaces6).append(spaces7).append(spaces8)
                .toString();
    }

}
