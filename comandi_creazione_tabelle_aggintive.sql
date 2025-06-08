CREATE TABLE users (
    id BIGINT AUTO_INCREMENT,                   -- ID utente univoco
    username VARCHAR(100) NOT NULL UNIQUE,      -- Username univoco
    password VARCHAR(255) NOT NULL,             -- Password (criptata)
    role VARCHAR(50) DEFAULT 'USER',            -- Ruolo (USER, ADMIN, ecc.)
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE quiz_score (
    id BIGINT AUTO_INCREMENT,
    user_id BIGINT,
    difficulty_level VARCHAR(20),
    correct_answers INT NOT NULL,
    total_questions INT NOT NULL,
    dt_attempt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_quiz_score PRIMARY KEY (id),
    CONSTRAINT fk_quiz_score_user FOREIGN KEY (user_id) REFERENCES users(id)
);