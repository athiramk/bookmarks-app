create sequence bm_id_seq start with 1 increment by 50;

create table bookmarks (
                           id bigint default nextval('bm_id_seq') not null,
                           title text not null,
                           url text not null,
                           created_at timestamp,
                           primary key (id)
);