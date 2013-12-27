<html>
<head>
<title>Search Result</title>
</head>	
<body>
	<div style="float: left">  
    <h4>Search Result</h4>  
    <table>  
        <tr>  
            <th>Bug Title</th>  
        </tr>  
    <#list bugs as bug>   
        <tr>  
            <td><a href="bug/${bug.bugNum}">${bug.bugNum} ${bug.title}</a></td>  
        </tr>  
    </#list>  
    </table>  
</body>
