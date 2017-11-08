<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>resCalculMensualite</title>
</head>
<body>
<f:view>
pour rembourser un montant de <b><h:outputText value="#{calculEmprunt.montant }" /></b> euros <br/>
sur une duree de <b><h:outputText value="#{calculEmprunt.nbAnnees }" /> </b>an(s) <br/>
et avec un taux d'intérêt annuel de <b><h:outputText value="#{calculEmprunt.tauxAnnuel }" /> % </b> <br/>
il faut des mensualites de <b><h:outputText value="#{calculEmprunt.mensualite }" /></b> .
</f:view>
</body>
</html>