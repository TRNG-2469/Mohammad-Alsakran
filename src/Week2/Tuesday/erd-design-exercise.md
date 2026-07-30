erDiagram
    BOOK ||--o{ LOAN : is_loaned_in
    MEMBER ||--o{ LOAN : makes

    BOOK {
        int Registration_code PK
        string Title
        string Author
        int Publishing_year
    }

    MEMBER {
        int Memb_card_num PK
        string Name
        string Email
        datetime Sign_Up
    }

    LOAN {
        int Loan_id PK
        int Memb_card_num FK
        int Registration_code FK
        date Checkout_date
        date Due_date
    }