CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    CURSOR c_savings IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings';

    v_interest NUMBER;
BEGIN
    FOR rec IN c_savings LOOP
        v_interest := rec.Balance * 0.01;

        UPDATE Accounts
        SET Balance = Balance + v_interest
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Account ID: ' || rec.AccountID ||
                             ' | Interest Added: $' || v_interest ||
                             ' | New Balance: $' || (rec.Balance + v_interest));
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processing completed.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END ProcessMonthlyInterest;
/