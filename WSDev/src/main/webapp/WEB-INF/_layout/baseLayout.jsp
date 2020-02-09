<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<tiles:insertAttribute name="header" />
<body
	class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed">
	<div class="wrapper">
		<!-- Navbar -->
		<tiles:insertAttribute name="navbar" />

		<!-- Sidebar  -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<tiles:insertAttribute name="sidebar" />
		</aside>

		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<tiles:insertAttribute name="body" />
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>