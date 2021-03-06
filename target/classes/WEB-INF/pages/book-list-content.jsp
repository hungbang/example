<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>

<a href="${pageContext.request.contextPath}/book">Add Book</a>

<table class="listing">
	<tr>
		<th>Title</th>
		<th>Description</th>
		<th>Price</th>
		<th>Publication Date</th>
	</tr>
	
	<c:forEach var="book" items="${books}" varStatus="status">
		<tr class="${status.index%2==0 ? 'alt' : ''}">
			<td><a href="${pageContext.request.contextPath}/book?id=${book.id}">${book.title}</a></td>
			<td>${book.description}</td>
			<td>
			<fmt:formatNumber value="${book.price}" type="currency"/>
			</td>
			<td>
			<fmt:formatDate value="${book.pubDate}" type="both" dateStyle ="short" timeStyle ="short"/>
			</td>
		</tr>
	</c:forEach>
</table>



Notice the use of <code>fmt:formatNumber</code> and <code>fmt:formatDate</code> as follows:

==== /WEB-INF/pages/book-list-content.jsp fmt:formatNumber and fmt:formatDate====
<pre>
<a href="${pageContext.request.contextPath}/book">Add Book</a>
...

			<fmt:formatNumber value="${book.price}" type="currency"/>
...
			<fmt:formatDate value="${book.pubDate}" type="both" dateStyle ="short" timeStyle ="short"/>
</table>