DROP TABLE IF EXISTS public.sm_user;
CREATE TABLE public.sm_user(
      id bigint PRIMARY KEY,
      firstName varchar(32),
      lastName varchar(32),
      userName varchar(32),
      password varchar(100),
      dateOfBirth date,
      createdAt timestamp,
      updatedAt timestamp
);