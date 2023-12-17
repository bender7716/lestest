insert into public.order_number (id, color, finish_date, name_order, number_order, quadrature, start_date)
values  (nextval('public.hibernate_sequence'), 'blue', '2023-12-28', 'ИП Саранин', '1698-К', 3.2, '2023-12-14'),
        (nextval('public.hibernate_sequence'), 'green', '2023-12-29', 'ИП Саранин', '1-К', 6.1, '2023-12-1');

insert into public.workplace (id, name_workplace)
values  (nextval('public.hibernate_sequence'), 'Бухгалтерия'),
        (nextval('public.hibernate_sequence'), 'Столярный'),
        (nextval('public.hibernate_sequence'), 'Шлифовальный'),
        (nextval('public.hibernate_sequence'), 'Малярный');

insert into public.technological_process (id, operation_code, time_finish_work, time_start_work, id_order, id_workplace)
values  (nextval('public.hibernate_sequence'), 1, null, null, 1, 3),
        (nextval('public.hibernate_sequence'), 2, null, null, 1, 4),
        (nextval('public.hibernate_sequence'), 3, null, null, 1, 5),
        (nextval('public.hibernate_sequence'), 4, null, null, 1, 6),
        (nextval('public.hibernate_sequence'), 1, '2023-12-1', '2023-12-1', 2, 4),
        (nextval('public.hibernate_sequence'), 2, null, null, 2, 6);

insert into public.baguette (id, baguette_name)
values  (nextval('public.hibernate_sequence'), 'Кромочный'),
        (nextval('public.hibernate_sequence'), '№4');

insert into public.cutter (id, cutter_name)
values  (nextval('public.hibernate_sequence'), 'Обводная'),
        (nextval('public.hibernate_sequence'), 'Aelita #5');

insert into public.order_baguette (id_order, id_baguette)
values  (1, 13),
        (1, 14);

insert into public.order_cutter (id_order, id_cutter)
values  (1, 15),
        (1, 16);