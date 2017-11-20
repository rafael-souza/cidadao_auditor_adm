package br.net.proex.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Classe auxiliar para tratamento de datas
 * 
 * @author Rafael Souza
 * 
 */
public final class DateTimeUtils {

	/**
	 * Recebe uma String com data no formato DD-MM-AAAA e devolve no formato
	 * AAAA-MM-DD.
	 * 
	 * @param data
	 *            Data a ser invertida.
	 * @since v1.0
	 * 
	 */
	public static String dataContrario(String data) {
		return data.substring(6) + "-" + data.substring(3, 5) + "-"
				+ data.substring(0, 2);
	}

	/**
	 * Recebe a data no formato DD/MM/AAAA e transforma em um objeto do tipo
	 * Date.
	 * 
	 * @param dataString
	 *            Data a ser transformada em um objeto Date
	 */
	public static Date string2Date(String dataString) {
		try {
			Calendar data = Calendar.getInstance();
			String ano, mes, dia;
			ano = dataString.substring(6);
			mes = dataString.substring(3, 5);
			dia = dataString.substring(0, 2);
			data.clear();
			data.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1,
					Integer.parseInt(dia));
			data.set(Calendar.HOUR, 0);
			data.set(Calendar.MINUTE, 0);
			data.set(Calendar.SECOND, 0);
			return data.getTime();

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Recebe a data no formato ddMMyyyy e transforma em um objeto do tipo Date.
	 * 
	 * @param dataLong
	 *            Data a ser transformada em um objeto Date
	 */
	public static Date long2Date(long dataLong) {
		try {
			String dataString = String.valueOf(dataLong);
			Calendar data = Calendar.getInstance();
			String ano, mes, dia;
			if (dataString.length() < 8) {
				dataString = "0" + dataString;
			}
			ano = dataString.substring(4);
			mes = dataString.substring(2, 4);
			dia = dataString.substring(0, 2);
			data.clear();
			data.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1,
					Integer.parseInt(dia));
			data.set(Calendar.HOUR, 0);
			data.set(Calendar.MINUTE, 0);
			data.set(Calendar.SECOND, 0);
			return data.getTime();

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Recebe a data no formato DD/MM/AAAA e transforma em um objeto do tipo
	 * Date.
	 * 
	 * @param dataString
	 *            Data a ser transformada em um objeto Date
	 */
	public static java.sql.Date formataDataRelatorioSql(String dataString) {
		try {
			if (dataString.isEmpty() || dataString == null) {
				return null;
			}

			int ano, mes, dia;
			ano = Integer.valueOf(dataString.substring(6));
			mes = Integer.valueOf(dataString.substring(3, 5));
			dia = Integer.valueOf(dataString.substring(0, 2));

			return new java.sql.Date(ano, mes, dia);

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Recebe a data no formato DD/MM/AAAA e verifica se é uma data válida.
	 * 
	 * @param dataString
	 *            Data a ser validada
	 */
	public static boolean isValidDate(String dataString) {
		try {
			Calendar data = Calendar.getInstance();
			int ano, mes, dia;
			ano = Integer.parseInt(dataString.substring(6));
			mes = Integer.parseInt(dataString.substring(3, 5));
			dia = Integer.parseInt(dataString.substring(0, 2));
			if (mes < 1 || mes > 12 || dia < 1 || ano < 1900) {
				return false;
			}

			if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
					|| mes == 10 || mes == 12)
					&& dia > 31) {
				return false;
			}

			if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
				return false;
			}

			if (mes == 2) {
				// se ano for bissexto e dia maior q 29, entao false
				if ((ano % 4) == 0 && dia > 29) {
					return false;
				} else if ((ano % 4) != 0 && dia > 28) {
					return false;
				}
			}

			data.clear();
			data.set(ano, mes - 1, dia);
			return true;
		} catch (Exception e) {
			// A IDEIA AQUI EH FAZER GERAR A EXCECAO MESMO PARA VERIFICAR A
			// VALIDADE
			// DA STRING INFORMADA. NAO DEVE GERAR LOG
			return false;
		}
	}

	/*
	 * -------------------------------------------------------------------------
	 * Valida se a data inicial é maior que a data final
	 * -------------------------------------------------------------------------
	 */
	public static Boolean validaDataInicialDataFinal(String dataInicial,
			String dataFinal) {
		try {
			if (string2Date(dataInicial).after(string2Date(dataFinal))) {
				return false;
			}

		} catch (Exception ex) {
			return null;
		}
		return true;
	}

	/**
	 * Valida as datas inicial, e final informadas nos parametros. <b>Importante
	 * observar que este metodo ignora os atributos relativos a hora.</b> Assim,
	 * se for informado 12/03/2012 12:05:00 e 12/03/2012 15:15:10 este metodo
	 * retornara <code>false</code>.
	 * 
	 * @param dataInicial
	 *            - Data Inicial para comparacao
	 * @param dataFinal
	 *            - Data Final para comparacao
	 * @return Retorna <code>false</code> se dataInicial for igual, ou anterior
	 *         a dataFinal.
	 */
	public static Boolean isDataFinalAnteriorDataInicial(Date dataInicial,
			Date dataFinal) {

		if (dataInicial == null || dataFinal == null) {
			throw new IllegalArgumentException(
					"A dataInicial e/ou dataFinal esta nula.");
		}

		dataInicial = DateTimeUtils.retiraHora(dataInicial);
		dataFinal = DateTimeUtils.retiraHora(dataFinal);
		if (dataFinal.before(dataInicial)) {
			return true;
		} else {
			return false;
		}

	}

	public static Date retiraHora(Date dataComHora) {
		if (dataComHora == null) {
			return null;
		}

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return (java.util.Date) formatter.parse(formatter
					.format(dataComHora));
		} catch (ParseException ex) {
			return null;
		}
		/*
		 * Calendar c = Calendar.getInstance(); c.setTime(dataComHora);
		 * 
		 * c.set(Calendar.HOUR,0); c.set(Calendar.MINUTE,0);
		 * c.set(Calendar.SECOND,0); c.set(Calendar.MILLISECOND, 0); return
		 * c.getTime();
		 */
	}

	/*
	 * -------------------------------------------------------------------------
	 * Converte uma data em String para Date
	 * -------------------------------------------------------------------------
	 */
	public static Date formataData(String data) throws Exception {
		if (data == null || data.equals("")) {
			return null;
		}
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (java.util.Date) formatter.parse(data);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

	/*
	 * -------------------------------------------------------------------------
	 * Retorna a data do sistema em String
	 * -------------------------------------------------------------------------
	 */
	public static String formataData(Date data) {
		try {
			SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
			return dataFormatada.format(data);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * -------------------------------------------------------------------------
	 * Retorna a data do sistema em String
	 * -------------------------------------------------------------------------
	 */
	public static String formataData(Date data, String formato) {
		if (formato == null) {
			formato = "dd/MM/yyyy";
		}
		if (data == null) {
			data = new Date();
		}

		SimpleDateFormat dataFormatada = new SimpleDateFormat(formato);
		return dataFormatada.format(data);
	}

	public static Calendar deslocaData(Calendar dataInicial, int numDias,
			boolean praFrente) {

		if (!praFrente) {
			numDias *= -1;
		}
		Date data = new Date();
		data.setDate(dataInicial.getTime().getDate());
		data.setMonth(dataInicial.getTime().getMonth());
		data.setYear(dataInicial.getTime().getYear());

		Calendar novaData = Calendar.getInstance();
		novaData.setTime(data);
		novaData.add(Calendar.DAY_OF_MONTH, numDias);

		return novaData;
	}

	public static Date setCurrentHourIn(Date data) {
		if (data == null) {
			return null;
		}

		Calendar dataOriginal = Calendar.getInstance(new Locale("pt", "BR"));
		dataOriginal.setTime(data);

		Calendar c = Calendar.getInstance(new Locale("pt", "BR"));
		c.setTime(new Date());
		c.set(Calendar.YEAR, dataOriginal.get(Calendar.YEAR));
		c.set(Calendar.MONTH, dataOriginal.get(Calendar.MONTH));
		c.set(Calendar.DAY_OF_MONTH, dataOriginal.get(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * Seta horário na data. Se firstTime for <code>true</code> seta 00:00:00
	 * senão, seta 23:59:59.
	 * 
	 * @param data
	 * @param firstTime
	 * @return Retorna a data com o horário de acordo com os parametros.
	 */
	public static Date setTimeInDate(Date data, Boolean firstTime) {
		if (data == null) {
			return null;
		}

		Calendar dataFormatada = Calendar.getInstance();
		dataFormatada.setTime(data);

		// indicando que é para setar o horário 00:00:00
		if (firstTime == true) {
			dataFormatada.set(Calendar.HOUR_OF_DAY, 00);
			dataFormatada.set(Calendar.MINUTE, 00);
			dataFormatada.set(Calendar.SECOND, 00);
		} else { // senão seta o horário para 23:59:59
			dataFormatada.set(Calendar.HOUR_OF_DAY, 23);
			dataFormatada.set(Calendar.MINUTE, 59);
			dataFormatada.set(Calendar.SECOND, 59);
		}

		return dataFormatada.getTime();

	}

	/**
	 * Recebe um objeto de Date e retorna um String no formato dd/MM/yyyy.
	 * 
	 * @param data
	 *            - Data a ser formatada.
	 * @return Se data for null, retorna null, senão, retorma String no formato
	 *         dd/MM/yyyy.
	 */
	public static String date2String(Date data) {
		if (data == null) {
			return null;
		}

		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}

	/**
	 * Recebe um objeto de Date e retorna um Long no formato ddMMyyyy.
	 * 
	 * @param data
	 *            - Data a ser formatada.
	 * @return Se data for null, retorna null, senão, retorma Long no formato
	 *         ddMMyyyy.
	 */
	public static Long date2Long(Date data) {
		if (data == null) {
			return null;
		}
		
		return Long.parseLong(new SimpleDateFormat("yyMMddHHmmss").format(data));
	}

	/**
	 * @return a diferenca dos dias entre a data final e a inicial se a data
	 *         inicial for maior retorna 0
	 */
	public static Integer diasDeDiferencaEntreDatas(Date dataInicial,
			Date dataFinal) {
		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();

		GregorianCalendar curTime = new GregorianCalendar();
		GregorianCalendar baseTime = new GregorianCalendar();

		// retirando a hora das datas
		dataInicial = retiraHora(dataInicial);
		dataFinal = retiraHora(dataFinal);

		startTime.setTime(dataInicial);
		endTime.setTime(dataFinal);

		// Verifica a ordem de inicio das datas
		if (dataInicial.after(dataFinal)) {
			return 0;
		}

		baseTime.setTime(dataFinal);
		curTime.setTime(dataInicial);

		int result_years = 0;
		int result_months = 0;
		int result_days = 0;

		// Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import
		// acumulando
		// no total de dias. Ja leva em consideracao ano bissexto
		while (curTime.get(GregorianCalendar.YEAR) < baseTime
				.get(GregorianCalendar.YEAR)
				|| curTime.get(GregorianCalendar.MONTH) < baseTime
						.get(GregorianCalendar.MONTH)) {

			int max_day = curTime
					.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			result_months += max_day;
			curTime.add(GregorianCalendar.MONTH, 1);

		}

		// Retirna a diferenca de dias do total dos meses
		result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime
				.get(GregorianCalendar.DAY_OF_MONTH));

		return result_years + result_months + result_days;
	}

	public static String ultimoDiaMes(Integer ano, Integer mes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.MONTH, mes);

		return String.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}

	public static int getAno(Date data) {
		if (data == null) {
			return 0;
		}

		return getCampoData(data, Calendar.YEAR);
	}

	public static int getDia(Date data) {
		if (data == null) {
			return 0;
		}

		return getCampoData(data, Calendar.DAY_OF_MONTH);
	}

	/**
	 * Retorna o mês do ano de acordo com a data informada. Ao contrário da
	 * classe Calendar, este método traz o número do mes de acordo com o
	 * calendário, onde Janeiro, é o mês 1.
	 * 
	 * @param data
	 * @return Retorna 1 para Janeiro, 2 Fevereiro, e assim por diante.
	 */
	public static int getMes(Date data) {
		if (data == null) {
			return 0;
		}

		return getCampoData(data, Calendar.MONTH) + 1;
	}

	private static int getCampoData(Date data, int campo) {
		if (data == null) {
			return 0;
		}

		Calendar c = Calendar.getInstance(new Locale("pt", "BR"));
		c.setTime(data);
		return c.get(campo);

	}

	/**
	 * Retorna a data de acordo com o formato exigido pelo Google, utilizado
	 * para realizar o sincronismo da Agenda
	 */
	public static Date formataDataGoogle(Date dataAgenda) {

		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("GMT-03:00"));
		c.setTime(dataAgenda);

		return c.getTime();
	}

	public static Boolean comparaDataGoogle(Date dataGoogle, Date dataAgenda) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		return sdf.format(dataAgenda).equals(sdf.format(dataGoogle));
	}

	/**
	 * Verifica se duas datas estão no mesmo dia independente do horário.
	 * 
	 * @param data1
	 * @param data2
	 * 
	 * @return Retorna <code>true</code> se as datas se referem ao mesmo dia,
	 *         ignorando possíveis diferenças de horário.
	 * 
	 */
	public static Boolean isMesmoDia(Date data1, Date data2) {
		data1 = retiraHora(data1);
		data2 = retiraHora(data2);
		return data1.getTime() == data2.getTime();
	}

	public static Date setTimeInDate(Date dataLancamento, String horaLancamento) {
		if (dataLancamento == null || horaLancamento == null) {
			return null;
		}

		Calendar data = Calendar.getInstance();
		data.setTime(dataLancamento);
		horaLancamento = horaLancamento.replace(":", "");

		data.set(Calendar.HOUR_OF_DAY,
				Integer.valueOf(horaLancamento.substring(0, 2)));
		data.set(Calendar.MINUTE,
				Integer.valueOf(horaLancamento.substring(2, 4)));

		return data.getTime();
	}

	public static Date deslocaSegundos(Date data) {
		if (data == null) {
			return null;
		}

		Calendar dataFormatada = Calendar.getInstance();
		dataFormatada.setTime(data);
		dataFormatada.set(Calendar.SECOND, 00);
		dataFormatada.set(Calendar.MILLISECOND, 00);

		return dataFormatada.getTime();

	}

	/**
	 * Formata a data dos arquivos de importação que são no formato yyyy-MM-dd
	 */
	public static Date getPrimeiroDia(int mes, int ano) {

		int dia = Integer.parseInt("01");
		Calendar retorno = Calendar.getInstance();
		retorno.set(ano, (mes - 1), dia, 0, 0, 0);
		retorno.set(Calendar.MILLISECOND, 0);

		return retorno.getTime();

	}

	/**
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Boolean isDatasIguais(Date dataInicial, Date dataFinal) {

		if (dataInicial == null || dataFinal == null) {
			throw new IllegalArgumentException(
					"A dataInicial e/ou dataFinal esta nula.");
		}

		dataInicial = DateTimeUtils.retiraHora(dataInicial);
		dataFinal = DateTimeUtils.retiraHora(dataFinal);
		return (dataFinal.equals(dataInicial));
	}

	/**
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Boolean isDataInicialMaiorDataFinal(Date dataInicial,
			Date dataFinal) {

		if (dataInicial == null || dataFinal == null) {
			throw new IllegalArgumentException(
					"A dataInicial e/ou dataFinal esta nula.");
		}

		dataInicial = DateTimeUtils.retiraHora(dataInicial);
		dataFinal = DateTimeUtils.retiraHora(dataFinal);
		return (dataInicial.before(dataFinal));
	}

	/**
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Boolean isDataInicialMaiorIgualDataFinal(Date dataInicial,
			Date dataFinal) {

		if (dataInicial == null || dataFinal == null) {
			throw new IllegalArgumentException(
					"A dataInicial e/ou dataFinal esta nula.");
		}

		dataInicial = DateTimeUtils.retiraHora(dataInicial);
		dataFinal = DateTimeUtils.retiraHora(dataFinal);
		return (dataInicial.before(dataFinal) || dataInicial.equals(dataFinal));
	}

	/**
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Boolean isDataInicialMenorDataFinal(Date dataInicial,
			Date dataFinal) {

		if (dataInicial == null || dataFinal == null) {
			throw new IllegalArgumentException(
					"A dataInicial e/ou dataFinal esta nula.");
		}

		dataInicial = DateTimeUtils.retiraHora(dataInicial);
		dataFinal = DateTimeUtils.retiraHora(dataFinal);
		return (dataInicial.after(dataFinal));
	}

	/**
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Boolean isDataInicialMenorIgualDataFinal(Date dataInicial,
			Date dataFinal) {

		if (dataInicial == null || dataFinal == null) {
			throw new IllegalArgumentException(
					"A dataInicial e/ou dataFinal esta nula.");
		}

		dataInicial = DateTimeUtils.retiraHora(dataInicial);
		dataFinal = DateTimeUtils.retiraHora(dataFinal);
		return (dataInicial.after(dataFinal) || dataInicial.equals(dataFinal));
	}

	
	/**
	 * 
	 * @return
	 */
	public static String retornaDataHoraTexto() {

		return String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
				+ (Calendar.getInstance().get(Calendar.MONTH) + 1 < 10 ? "0"
						+ String.valueOf(Calendar.getInstance().get(
								Calendar.MONTH) + 1) : String.valueOf(Calendar
						.getInstance().get(Calendar.MONTH) + 1))
				+ (Calendar.getInstance().get(Calendar.DATE) < 10 ? "0"
						+ String.valueOf(Calendar.getInstance().get(
								Calendar.DATE)) : String.valueOf(Calendar
						.getInstance().get(Calendar.DATE)))
				+ (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 10 ? "0"
						+ String.valueOf(Calendar.getInstance().get(
								Calendar.HOUR_OF_DAY)) : String
						.valueOf(Calendar.getInstance().get(
								Calendar.HOUR_OF_DAY)))
				+ (Calendar.getInstance().get(Calendar.MINUTE) < 10 ? "0"
						+ String.valueOf(Calendar.getInstance().get(
								Calendar.MINUTE)) : String.valueOf(Calendar
						.getInstance().get(Calendar.MINUTE)))
				+ (Calendar.getInstance().get(Calendar.SECOND) < 10 ? "0"
						+ String.valueOf(Calendar.getInstance().get(
								Calendar.SECOND)) : String.valueOf(Calendar
						.getInstance().get(Calendar.SECOND)));

	}
	
	
	/**
	 * Soma ou subtrar um determinado número de dias de uma data inicial, devolvendo a
	 * data resultante
	 * @param dataInicial Data inicial
	 * @param numDias Número de dias, positivo ou negativo, para conta.
	 * @return Data resultante
	 */
	public static Date addDays(Date dataInicial, int numDias) {
		long aAdicionar = ((24 * 60 * 60 * 1000) * (long)numDias);		
		long tempoFinal =	dataInicial.getTime() + aAdicionar;
		
		Date dataFinal = new Date(tempoFinal);

		return dataFinal;

	}	

}
