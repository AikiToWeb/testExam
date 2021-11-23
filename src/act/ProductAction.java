package act;

import javax.servlet.http.*;
import java.util.*; // ArrayList��
import java.io.*;
import svc.*;
import vo.*;

public class ProductAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductService productService = new ProductService();
		ArrayList<ProductInfo> pdtList = productService.getImg();

		request.setAttribute("pdtList", pdtList);
		// ������ �ν��Ͻ����� request��ü�� �Ӽ����� �����Ͽ� �̵��� �������� ������

		ActionForward forward = new ActionForward();
		forward.setPath("product_list.jsp");

		return forward;
	}

	private boolean isEmpty(String str) { // ���ڿ��� � ���̵� ��� �ִ��� ���θ� �˻��ϴ� �޼ҵ�
		boolean empty = true;
		if (str != null && !str.equals(""))
			empty = false;
		return empty;
	}
}
