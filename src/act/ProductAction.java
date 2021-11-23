package act;

import javax.servlet.http.*;
import java.util.*; // ArrayList용
import java.io.*;
import svc.*;
import vo.*;

public class ProductAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductService productService = new ProductService();
		ArrayList<ProductInfo> pdtList = productService.getImg();

		request.setAttribute("pdtList", pdtList);
		// 생성한 인스턴스들을 request객체의 속성으로 저장하여 이동할 페이지로 가져감

		ActionForward forward = new ActionForward();
		forward.setPath("product_list.jsp");

		return forward;
	}

	private boolean isEmpty(String str) { // 문자열에 어떤 값이든 들어 있는지 여부를 검사하는 메소드
		boolean empty = true;
		if (str != null && !str.equals(""))
			empty = false;
		return empty;
	}
}
