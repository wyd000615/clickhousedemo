create table cs_user_info(
    id UInt32,
    user_name String,
    pass_word String,
    phone String,
    email String,
    create_day String
)engine = TinyLog;