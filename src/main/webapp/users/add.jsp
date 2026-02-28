<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800">UsersCRUD</h1>


    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Add user</h6>

        </div>

        <form action="add" method="post">
            <div class="form-group">
                <label>Nazwa</label>
                <input type="text" name="userName" class="form-control" placeholder="Nazwa użytkownika">
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" class="form-control" placeholder="Email użytkownika">
            </div>
            <div class="form-group">
                <label>Hasło</label>
                <input type="password" name="password" class="form-control" placeholder="Hasło użytkownika">
            </div>
            <button type="submit" class="btn btn-primary">Zapisz</button>
        </form>


        <div class="card-body">
            <div class="table-responsive">

            </div>
        </div>

</div>
<!-- End Page Content -->

<%@ include file="../footer.jsp" %>