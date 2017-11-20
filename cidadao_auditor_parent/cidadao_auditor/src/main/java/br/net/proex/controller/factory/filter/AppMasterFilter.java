package br.net.proex.controller.factory.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.powerlogic.jcompany.commons.config.qualifiers.QPlcDefaultLiteral;
import com.powerlogic.jcompany.commons.util.cdi.PlcCDIUtil;
import com.powerlogic.jcompany.controller.filter.PlcMasterFilter;
import com.powerlogic.jcompany.controller.util.PlcMsgUtil;
import com.powerlogic.jcompany.domain.validation.PlcMessage;

import br.net.proex.controller.exception.AppAcessoNegadoException;
import br.net.proex.controller.exception.AppLoginNegadoException;


public class AppMasterFilter extends PlcMasterFilter{
	
	@Override
	protected void trataExcecaoFilter(ServletRequest request, ServletResponse response, Exception e) throws IOException {
		
		if (e instanceof AppAcessoNegadoException) {
			PlcMsgUtil msgUtil = PlcCDIUtil.getInstance().getInstanceByType(PlcMsgUtil.class, QPlcDefaultLiteral.INSTANCE);
			msgUtil.msg(e.getMessage(), PlcMessage.Cor.msgVermelhoPlc.toString());
			RequestDispatcher rq = request.getRequestDispatcher("/");
		
			try {
				rq.forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			}
		
		} else if (e instanceof AppLoginNegadoException) {		
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath());
		} else {
			super.trataExcecaoFilter(request, response, e);
		}	
	}
	
}
