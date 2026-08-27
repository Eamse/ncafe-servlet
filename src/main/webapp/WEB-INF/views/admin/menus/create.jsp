<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>메뉴 등록 — 우리카페</title>
  </head>
  <body>
    <div>
      <header>
        <h1>우리카페</h1>
      </header>
      <div>
        <aside>
          <h2>사이드바</h2>
          <nav>
            <h3>관리 메뉴</h3>
            <ul>
              <li><a href="">카테고리 관리</a></li>
              <li><a href="/admin/menus/list">메뉴 관리</a></li>
            </ul>
          </nav>
          <nav>
            <h3>바로가기 메뉴</h3>
            <div>
              <a href="">홈으로</a>
            </div>
          </nav>
        </aside>
        <main>
          <header>
            <h2>새 메뉴 등록</h2>
            <div>
              <p>새로운 메뉴의 정보를 입력해주세요</p>
              <a href="/admin/menus/list">목록</a>
            </div>
          </header>
          <nav>
            <h3>경로</h3>
            <ol>
              <li><a href="">홈</a></li>
              <li><a href="/admin/menus/list">메뉴 목록</a></li>
              <li><a href="/admin/menus/create">메뉴 등록</a></li>
            </ol>
          </nav>
          <section>
            <h3>메뉴 등록 폼</h3>
            <form id="form-for-menu" method="post" action="/admin/menus/create">
              <div>
                <label>이미지</label>
                <input
                  type="text"
                  name="img-src"
                  placeholder="이미지 파일명 또는 경로"
                />
              </div>
              <div>
                <label>한국명*</label>
                <input
                  type="text"
                  required
                  placeholder="예:카페라테"
                  autofocus
                  name="kor-name"
                  autocomplete="off"
                />
              </div>
              <div>
                <label>영문명*</label>
                <input
                  type="text"
                  required
                  placeholder="예:Cafe Latte"
                  name="eng-name"
                />
              </div>
              <div>
                <label>가격*</label>
                <input type="text" required name="price" />
              </div>
              <div>
                <label>카테고리</label>
                <select name="category-id">
                  <option value="">카테고리 선택</option>
                  <option value="1">커피</option>
                  <option value="2">차</option>
                  <option value="3">디저트</option>
                  <option value="4">에이드</option>
                </select>
              </div>
              <div>
                <label>설명</label>
                <textarea
                  rows="10"
                  cols="40"
                  placeholder="메뉴 설명을 입력하세요"
                  name="description"
                ></textarea>
              </div>
              <div>
                <button type="submit">전송</button>
                <a href="/admin/menus/list">취소</a>
              </div>
            </form>
          </section>
        </main>
      </div>
    </div>
  </body>
</html>
