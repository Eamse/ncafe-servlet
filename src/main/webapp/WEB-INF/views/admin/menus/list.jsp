<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메뉴 관리 | 카페 관리자</title>
</head>
<body>

    <header>
        <span aria-hidden="true">&#9749;</span>
        <span>카페 관리자</span>
        <span>홈으로</span>
    </header>

    <nav aria-label="관리 메뉴">
        <p>관리 메뉴</p>
        <ul>
            <li>카테고리관리</li>
            <li>메뉴관리</li>
        </ul>
    </nav>

    <main>
        <header>
            <h1>메뉴 관리</h1>
            <p>등록된 메뉴를 확인하고 상세/수정/삭제할 수 있습니다.</p>
            <button type="button">+ 새 메뉴 등록</button>
        </header>

        <section>
            <h2>검색폼</h2>
            <form action="${pageContext.request.contextPath}/admin/menus/list" method="get">
                <label>🔍 검색어
                    <input type="text" name="keyword" placeholder="메뉴명, 카테고리명">
                </label>

                <label>카테고리
                    <select name="categoryId">
                        <option value="">전체</option>
                    </select>
                </label>

                <button type="submit">검색</button>
            </form>
        </section>

        <section>
            <h2>메뉴 목록</h2>
            <table border="1">
                <caption>메뉴 관리 목록</caption>
                <thead>
                    <tr>
                        <th></th>
                        <th>메뉴명</th>
                        <th>카테고리</th>
                        <th>가격</th>
                        <th>등록일</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="menu" items="${list}">
                        <tr>
                            <td><img src="${menu.imgSrc}" alt="${menu.korName}"></td>
                            <td>
                                <span>${menu.korName}</span>
                                <span>${menu.engName}</span>
                            </td>
                            <td>${menu.categoryId}</td>
                            <td>${menu.price}원</td>
                            <td>${menu.createTime}</td>
                            <td>
                                <span>상세</span>
                                <span>수정</span>
                                <button type="button">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </main>

    <footer>
        <p>&copy; 2026 카페 관리자. All rights reserved.</p>
    </footer>

</body>
</html>
