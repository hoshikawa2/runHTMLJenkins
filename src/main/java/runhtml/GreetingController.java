package runhtml;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
        
    public String template = ", seja bem vindo %s!";

    @RequestMapping("/showhtml")
    public String greeting(@RequestParam(value="sku", defaultValue="12345") String sku,
    		@RequestParam(value="lista", defaultValue="1") String lista,
    		@RequestParam(value="nome", defaultValue="Cristiano") String nome,
    		@RequestParam(value="preco", defaultValue="123,43") String preco) {
    	String msgOut = "\r\n" + 
    			"<html>\r\n" + 
    			"\r\n" + 
    			"<head>\r\n" + 
    			"\r\n" + 
    			"<style>\r\n" + 
    			"<!--table\r\n" + 
    			"	{mso-displayed-decimal-separator:\"\\.\";\r\n" + 
    			"	mso-displayed-thousand-separator:\"\\.\";}\r\n" + 
    			"@page\r\n" + 
    			"	{margin:.75in .7in .75in .7in;\r\n" + 
    			"	mso-header-margin:.3in;\r\n" + 
    			"	mso-footer-margin:.3in;}\r\n" + 
    			"-->\r\n" + 
    			"tr\r\n" + 
    			"	{mso-height-source:auto;}\r\n" + 
    			"col\r\n" + 
    			"	{mso-width-source:auto;}\r\n" + 
    			"br\r\n" + 
    			"	{mso-data-placement:same-cell;}\r\n" + 
    			".style0\r\n" + 
    			"	{mso-number-format:General;\r\n" + 
    			"	text-align:general;\r\n" + 
    			"	vertical-align:bottom;\r\n" + 
    			"	white-space:nowrap;\r\n" + 
    			"	mso-rotate:0;\r\n" + 
    			"	mso-background-source:auto;\r\n" + 
    			"	mso-pattern:auto;\r\n" + 
    			"	color:black;\r\n" + 
    			"	font-size:11.0pt;\r\n" + 
    			"	font-weight:400;\r\n" + 
    			"	font-style:normal;\r\n" + 
    			"	text-decoration:none;\r\n" + 
    			"	font-family:Calibri, sans-serif;\r\n" + 
    			"	mso-font-charset:0;\r\n" + 
    			"	border:none;\r\n" + 
    			"	mso-protection:locked visible;\r\n" + 
    			"	mso-style-name:Normal;\r\n" + 
    			"	mso-style-id:0;}\r\n" + 
    			"td\r\n" + 
    			"	{mso-style-parent:style0;\r\n" + 
    			"	padding-top:1px;\r\n" + 
    			"	padding-right:1px;\r\n" + 
    			"	padding-left:1px;\r\n" + 
    			"	mso-ignore:padding;\r\n" + 
    			"	color:black;\r\n" + 
    			"	font-size:11.0pt;\r\n" + 
    			"	font-weight:400;\r\n" + 
    			"	font-style:normal;\r\n" + 
    			"	text-decoration:none;\r\n" + 
    			"	font-family:Calibri, sans-serif;\r\n" + 
    			"	mso-font-charset:0;\r\n" + 
    			"	mso-number-format:General;\r\n" + 
    			"	text-align:general;\r\n" + 
    			"	vertical-align:bottom;\r\n" + 
    			"	border:none;\r\n" + 
    			"	mso-background-source:auto;\r\n" + 
    			"	mso-pattern:auto;\r\n" + 
    			"	mso-protection:locked visible;\r\n" + 
    			"	white-space:nowrap;\r\n" + 
    			"	mso-rotate:0;}\r\n" + 
    			".xl65\r\n" + 
    			"	{mso-style-parent:style0;\r\n" + 
    			"	text-align:center;}\r\n" + 
    			".xl66\r\n" + 
    			"	{mso-style-parent:style0;\r\n" + 
    			"	color:white;\r\n" + 
    			"	text-align:center;\r\n" + 
    			"	background:black;\r\n" + 
    			"	mso-pattern:black none;}\r\n" + 
    			".xl67\r\n" + 
    			"	{mso-style-parent:style0;\r\n" + 
    			"	color:white;\r\n" + 
    			"	background:black;\r\n" + 
    			"	mso-pattern:black none;}\r\n" + 
    			"\r\n" + 
    			"</style>\r\n" + 
    			"\r\n" + 
    			"</script>\r\n" + 
    			"<![endif]>\r\n" + 
    			"</head>\r\n" + 
    			"\r\n" + 
    			"<body link=\"#0563C1\" vlink=\"#954F72\">\r\n" + 
    			"\r\n" + 
    			"<table border=0 cellpadding=0 cellspacing=0 width=1381 style='border-collapse:\r\n" + 
    			" collapse;table-layout:fixed;width:1034pt'>\r\n" + 
    			" <col width=182 style='mso-width-source:userset;mso-width-alt:6456;width:136pt'>\r\n" + 
    			" <col width=64 span=2 style='width:48pt'>\r\n" + 
    			" <col width=763 style='mso-width-source:userset;mso-width-alt:27136;width:572pt'>\r\n" + 
    			" <col width=154 span=2 style='mso-width-source:userset;mso-width-alt:5461;\r\n" + 
    			" width:115pt'>\r\n" + 
    			" <tr height=19 style='height:14.4pt'>\r\n" + 
    			"  <td colspan=6 height=19 class=xl66 width=1381 style='height:14.4pt;\r\n" + 
    			"  width:1034pt'>Lista de Preços</td>\r\n" + 
    			" </tr>\r\n" + 
    			" <tr height=19 style='height:14.4pt'>\r\n" + 
    			"  <td height=19 class=xl67 style='height:14.4pt'>SKU</td>\r\n" + 
    			"  <td colspan=3 class=xl66>Descrição</td>\r\n" + 
    			"  <td class=xl67>Notas</td>\r\n" + 
    			"  <td class=xl67>Preço</td>\r\n" + 
    			" </tr>\r\n" + 

    			" <tr height=19 style='height:14.4pt'>\r\n" + 
    			"  <td height=19 style='height:14.4pt'>" + sku + "</td>\r\n" + 
    			"  <td colspan=3 class=xl65>" + nome + "</td>\r\n" + 
    			"  <td class=xl65>" + lista + "</td>\r\n" + 
    			"  <td class=xl65>R$ " + preco + "</td>\r\n" + 
    			" </tr>\r\n" + 
    			" <tr height=19 style='height:14.4pt'>\r\n" + 
    			"  <td colspan=6 height=19 class=xl66 style='height:14.4pt'>Notas</td>\r\n" + 
    			" </tr>\r\n" + 
    			" <tr height=19 style='height:14.4pt'>\r\n" + 
    			"  <td height=19 class=xl65 style='height:14.4pt'>1</td>\r\n" + 
    			"  <td colspan=5 class=xl65>Para esse item é obrigatório adicionar a Bomba de\r\n" + 
    			"  Refrigeração (BOMBA)</td>\r\n" + 
    			" </tr>\r\n" + 
    			" <![if supportMisalignedColumns]>\r\n" + 
    			" <tr height=0 style='display:none'>\r\n" + 
    			"  <td width=182 style='width:136pt'></td>\r\n" + 
    			"  <td width=64 style='width:48pt'></td>\r\n" + 
    			"  <td width=64 style='width:48pt'></td>\r\n" + 
    			"  <td width=763 style='width:572pt'></td>\r\n" + 
    			"  <td width=154 style='width:115pt'></td>\r\n" + 
    			"  <td width=154 style='width:115pt'></td>\r\n" + 
    			" </tr>\r\n" + 
    			" <![endif]>\r\n" + 
    			"</table>\r\n" + 
    			"\r\n" + 
    			"</body>\r\n" + 
    			"\r\n" + 
    			"</html>";
        return msgOut;
    }
}
