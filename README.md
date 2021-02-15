#Hi Everyone

###Ecommerce Shopping Web Application 'Amazon' prototype

##Task:
Build a shopping application where items should be viewed and select to place order. Show my cart, display invoice and update and store
the user selection in the database. Also it should authenticate the user and store all his/her shopping selection and generate invoice.

##Summary:
This app is build using struts framework. The code is closed for modification and open for extension. We can add as many different types of shops and items as we want. Its possible to just add the additional feature without modifing the existing architecture.

##Functionality:
This application first authenticates the user with verifying your input with database. And from welcome page you will be taken to shopping page, different items will be displayed in shops. You can choose any item you want and move to next shop. At last you will taken to your cart. You can go to your cart anytime. The items added to your cart is unique, since your cart data is stored in database there is no need to worry about session; your data is safe even though your session is lost. From your cart you can place your order just like Amazon.in, after placing order database will be updated and invoice will be generated.

##Tools and Technologies:
* Java
* Servlet
* JSP
* JDBC
* RDBMS-MySQL 
* Bootstrap css
* HTML 5
* Apache Tomcat
* Struts