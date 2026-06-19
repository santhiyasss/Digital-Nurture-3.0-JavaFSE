DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, l.EndDate, c.CustomerID, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('REMINDER: Dear ' || rec.Name ||
                             ', your loan (ID: ' || rec.LoanID ||
                             ') is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY') ||
                             '. Please ensure timely repayment.');
    END LOOP;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No loans due in the next 30 days.');
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/