# e-shop-svc
============


My requirements are as follows:
-------------------------------
1. I want to get the list of all the products across all the categories                     
URL : http://<HostName:Port>/e-shop-svc/api/product/all-products 

2. I want to get the list of all the products by category or of a price less than or greater than a specified price for that product       
URL : http://<HostName:Port>/e-shop-svc/api/product/products-by-category?category=Mobiles                              
URL : http://<HostName:Port>/e-shop-svc/api/product/products-by-category-less-than-price-and-greater-than-price?category=Mobiles&lessThanPrice=60000&greaterThanPrice=30000

3. I want to get the list of all the products by company or of a price less than or greater than a specified price for that company                   
URL : http://<HostName:Port>/e-shop-svc/api/product/products-by-company?company=Intel                         
URL : http://<HostName:Port>/e-shop-svc/api/product/products-by-company-less-than-price-and-greater-than-price?company=Intel&lessThanPrice=70000&greaterThanPrice=50000

4. I want to get the discounted price of all the products by category                                        
URL : http://<HostName:Port>/e-shop-svc/api/product/discounted-price-by-category?category=Mobiles

5. I should be able to place a dummy order in a separate (database) instance. Order placement should fail if the stock = number of dummy orders 
6. I should be able to get the available stock details across products. This should consider the dummy orders placed and return stocks accordingly. 
7. I should be able to delete the dummy order(s)



Furthermore: 
------------
Assume that as a developer, just when you started building this application -  
Spring framework (Spring core, Spring IOC, AOP, boot etc.) and JPA / Hibernate became licensed softwares and you cannot use it now without paying license fees. The client is not willing to pay for any licenses so you have no other choice but to find another way to build REST endpoints. 

Don't worry about authentication /authorization of the APIs, let it be open to all. 

Your architect "suggested" to use the following solutions, but no harm using something else instead.
1. JDBI3 instead of JPA
2. Embedded Postgres DB instead of a full blown DB setup using some dependency like 
   <dependency>
		<groupId>com.opentable.components</groupId>
		<artifactId>otj-pg-embedded</artifactId>
   </dependency>
3. Anything except Spring to build the REST Endpoints.    
         
==========================================================================   
