<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">tt</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">1</a></li>
								<li class="breadcrumb-item active">2</li>
							</ol>
						</div>
					</div>
				</div>
			</div>

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