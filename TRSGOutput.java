
package pe.com.scotiabank.tbk.payment.tramas.output;

import pe.com.scotiabank.tbk.payment.util.PaymentWsConstants;
import pe.com.scotiabank.tbk.util.trama.Body;

public class TRSGOutput implements Body
{
    private String order;

    public TRSGOutput()
    {

    }

    public TRSGOutput(String output)
    {
        setStringBody(output);
    }

    @Override
    public void setStringBody(String output)
    {
        order = output.substring(0, PaymentWsConstants.TBK_TRSG_LENGTH_ORDER);
    }

    @Override
    public String getStringBody()
    {
        return new StringBuilder().append(order).toString();
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

}
