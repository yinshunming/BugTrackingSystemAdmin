<html>
<head>
<title>I18N Bugs</title>
</head>
<body>
	<form name="search" action="search" method="get">
		Owner:
		<input type="text" name="byOwner"/>
		<br/>
		<input type="submit" value="Submit" />
	</form>
	<a href="add">add</a>
	<div style="float: left">  
    <h4>List of bugs.</h4>  
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
</div>  

</body>
</html>