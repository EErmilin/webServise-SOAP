package webServise;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IwebServise {
    @WebMethod
    public String[] auth();
    public String[] getMenu(Integer role);
    public Integer getRole();
    public Object[] getServises();
    public String[] authMenu(Integer N);
    public String addServise(String name, String time, String sum);
    public String deleteServise(Integer i);
    public Object[] getFreeTime(String selectDate);
    public String takeTime(String selectDate, String time, String I);
    public String deleteTime(Integer I);
}