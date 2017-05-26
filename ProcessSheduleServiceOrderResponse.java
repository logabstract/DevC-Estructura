
package pe.com.scotiabank.tbk.payment.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import pe.com.scotiabank.tbk.util.beans.Response;
import pe.com.scotiabank.tbk.util.beans.Status;

@XmlRootElement(name = "ProcessSheduleServiceOrderResponse", namespace = "http://response.jaxws.tbk.scotiabank.com.pe")
@XmlType(name = "")
public class ProcessSheduleServiceOrderResponse extends Response
{
    private static final long serialVersionUID = 1L;
    private String order;

    public ProcessSheduleServiceOrderResponse()
    {

    }

    public ProcessSheduleServiceOrderResponse(Status status)
    {
        super(status);
    }

    public ProcessSheduleServiceOrderResponse(String code, String message)
    {
        super(code, message);
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
