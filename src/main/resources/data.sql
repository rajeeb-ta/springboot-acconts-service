insert into Accounts
values(10001,'Ranga','Savings', '2020-07-01', 'SGD',  10234.00);

insert into Accounts
values(10002,'Ravi', 'Current', '2020-07-01', 'SGD',  10234.00);

insert into Account_Transactions (account_Number, account_Name,value_Date,currency,debit_Amount,debit_Credit)
values(10001, 'Ranga','2020-07-01', 'SGD',  100.00, 'debit');

insert into Account_Transactions (account_Number, account_Name,value_Date,currency,credit_Amount,debit_Credit)
values(10001, 'Ranga','2020-06-01', 'SGD',  500.00, 'credit');

insert into Account_Transactions (account_Number, account_Name,value_Date,currency,debit_Amount,debit_Credit)
values(10002,'Ravi',  '2020-07-01', 'SGD',  234.00,  'debit');