create table admin_acc(
	username char(20) not null,
    pass char(20) not null,
    primary key(username)
);

create table nhan_vien(
    ten_nv nvarchar(50) not null,
    tuoi int ,
    gioi_tinh bit,
    dia_chi nvarchar(200),
    sdt char(50),
    loai_nhan_vien nvarchar(50),
    luong int not null,
    primary key(ten_nv)
);

create table acc(
	ten_nv nvarchar(50) not null,
	username char(20) not null,
    pass char(20)  not null,
    primary key(ten_nv),
    foreign key(ten_nv) references nhan_vien(ten_nv)
);



create table ds_san_pham(
    ten_sp nvarchar(100) not null,
    loai_sp nvarchar(50) not null,
    ton_kho int not null,
    gia_mua int not null,
    gia_ban int not null,
    primary key(ten_sp)
);

create table chi_tiet_sp(
	ten_sp nvarchar(100) not null,
	ref1 nvarchar(100),
    ref2 nvarchar(100),
    ref3 nvarchar(100),
    the_loai nvarchar(100),
    foreign key (ten_sp) references ds_san_pham(ten_sp)
);

create table hoa_don(
	ma_hd int not null auto_increment,
    nguoi_ban nvarchar(50) not null,
    ngay_ban char(20) not null,
    ten_khach_hang nvarchar(50) not null,
    sdt char(20),
    primary key(ma_hd)
);

create table chi_tiet_hd(
	ma_hd int not null,
    ten_sp nvarchar(100) not null,
    so_luong int,
    primary key(ma_hd,ten_sp),
    foreign key(ma_hd) references hoa_don(ma_hd),
    foreign key(ten_sp) references ds_san_pham(ten_sp)
);

create table chi_phi_phat_sinh(
	ten_chi_phi nvarchar(200) not null,
    so_tien int not null,
    tren_don_vi nvarchar(20) not null,
    primary key(ten_chi_phi)
);

