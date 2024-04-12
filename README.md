to open the front-end => 
1-   git clone https://github.com/mariem-mathlouthi/projet_integration.git
2-   cd laravel 
3-   cd front-end
4=   npm install --force
5-   npm run dev       => to run the project


when you make git clone https://github.com/....   =>  you'll get two folder front-end and backend 
after you've run the front-end you should run the backend and the server side with xampp or any database management tool you use

to run the backend =>

1-    cd backend
2-    composer install
3-    Copy the .env.example file and rename it to .env
4-    Create a new database with your specified name and put it in the .env file using XAMPP or another database management tool.
5-    php artisan migrate   => to migrate all the migrations
