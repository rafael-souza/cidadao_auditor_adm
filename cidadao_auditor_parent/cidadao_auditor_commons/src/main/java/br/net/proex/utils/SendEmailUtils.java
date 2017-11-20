package br.net.proex.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.net.proex.entity.ParametrosAplicacaoEntity;

/**
 * 
 * @author rafael
 *
 */
public final class SendEmailUtils {

//	public static Boolean SendEmail(final ParametrosAplicacaoEntity parametros, String mensagem, String subject, String destinatarios) {
//		Properties props = new Properties();
//		/** Parâmetros de conexão com servidor Gmail */
//		props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
//		props.put("mail.smtp.starttls.enable","true"); 
//		props.put("mail.smtp.host", parametros.getHostSmtp()); //server SMTP do GMAIL
//		props.put("mail.smtp.auth", "true"); //ativa autenticacao
//		props.put("mail.smtp.user", parametros.getEmail()); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)
//		props.put("mail.debug", "true");
//		props.put("mail.smtp.port", parametros.getPortaSmtp()); //porta
//		props.put("mail.smtp.socketFactory.port", parametros.getPortaSmtp()); //mesma porta para o socket
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.socketFactory.fallback", "false");
//
//		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(parametros.getEmail(), parametros.getSenhaEmail());
//			}
//		});
//		/** Ativa Debug para sessão */
//		session.setDebug(true);
//		try {
//			Message message = new MimeMessage(session);
//			// Remetente
//			message.setFrom(new InternetAddress(parametros.getEmail())); 			
//			// Destinatário(s)
//			Address[] toUser = InternetAddress.parse(destinatarios);
//			message.setRecipients(Message.RecipientType.TO, toUser);
//			// Assunto
//			message.setSubject(subject);
//			// mensagem
//			message.setText(mensagem);
//			/** Método para enviar a mensagem criada */
//			Transport.send(message);
//			// retornando sucesso noenvio
//			return Boolean.TRUE;
//		} catch (MessagingException e) {
//			e.printStackTrace();
//			return Boolean.FALSE;
//		}
//	}

	
	public static Boolean SendEmail(final ParametrosAplicacaoEntity parametros, String mensagem, String subject, String destinatarios) {	
		Properties props = new Properties();
		// quem estiver utilizando um SERVIDOR PROXY descomente essa parte e atribua as propriedades do SERVIDOR PROXY utilizado
	    /*
	    props.setProperty("proxySet","true");
	    props.setProperty("socksProxyHost","192.168.155.1"); // IP do Servidor Proxy
	    props.setProperty("socksProxyPort","1080");  // Porta do servidor Proxy
	    */
		props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.host", parametros.getHostSmtp()); //server SMTP do GMAIL
		props.put("mail.smtp.auth", "true"); //ativa autenticacao
		props.put("mail.smtp.user", parametros.getEmail()); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", parametros.getPortaSmtp()); //porta
		props.put("mail.smtp.socketFactory.port", parametros.getPortaSmtp()); //mesma porta para o socket
		//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		//Cria um autenticador que sera usado a seguir
		SimpleAuth auth = null;
		auth = new SimpleAuth ("seuusuarioparalogin","suasenhaparalogin");
//		auth = new SimpleAuth(parametros.getEmail(), parametros.getSenhaEmail());
		//Session - objeto que ira realizar a conexão com o servidor
		/*Como há necessidade de autenticação é criada uma autenticacao que
		 * é responsavel por solicitar e retornar o usuário e senha para 
		 * autenticação */
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true); //Habilita o LOG das ações executadas durante o envio do email
		//	Objeto que contém a mensagem
		Message msg = new MimeMessage(session);
		try {
			//Setando o destinatário
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatarios));
			//Setando a origem do email
			msg.setFrom(new InternetAddress(parametros.getEmail()));
			//Setando o assunto
			msg.setSubject(subject);
			//Setando o conteúdo/corpo do email
			msg.setContent(mensagem,"text/html;charset=UTF-8");
		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}
		//	Objeto encarregado de enviar os dados para o email
		Transport tr;
		try {
			tr = session.getTransport("smtp"); //define smtp para transporte
			/*
			 *  1 - define o servidor smtp
			 *  2 - seu nome de usuario do gmail
			 *  3 - sua senha do gmail
			 */
			tr.connect(parametros.getHostSmtp(), parametros.getEmail(), parametros.getSenhaEmail());
			msg.saveChanges(); // don't forget this
			//envio da mensagem
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
			return Boolean.TRUE;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(">> Erro: Envio Mensagem");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	
	}

	
		
}
