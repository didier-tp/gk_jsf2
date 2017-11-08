<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK rel="stylesheet" href="../css/styles.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<h2>calcul emprunt </h2>
	<h:messages styleClass="RedCssClass"/>
     <h:form>
     montant: <h:inputText value="#{calculEmprunt.montant }" /> <br/>
     nbAnnees: <h:inputText value="#{calculEmprunt.nbAnnees }" /> <br/>
     taux interet: <h:inputText value="#{calculEmprunt.tauxAnnuel }" /> % <br/>
     <h:commandButton value="calcul mensualite" action="#{calculEmprunt.calculerMensualite }" />
     </h:form>
</f:view>
</body>
</html>