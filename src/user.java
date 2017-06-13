

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Servlet implementation class user
 */
@WebServlet("/user")
public class user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.excellist(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public String excellist(HttpServletResponse response) throws Exception{
		System.out.println("dfsfa");
		try {
		Workbook wb=new HSSFWorkbook();
//		List<Order> orders=new List<Order>();
		String headers[]={"订单号","生成订单时间","收件人姓名","收件人地址","收件人电话","收件人邮编","寄件人姓名","寄件人地址","寄件人电话","寄件人邮编","操作人","快件重量","费用","快件状态"};
		 String headers1[]={"编号","姓名","电话","Email","QQ"};
		ExcelUtil.fillExcelData2(wb, headers, headers1);
		ResponseUtil.export(response, wb, "订单信息导出.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
