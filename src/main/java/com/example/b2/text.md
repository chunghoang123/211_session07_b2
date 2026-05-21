[Vận dụng cơ bản 2] - Chặn hành động bằng ngoại lệ


BÀI 2: VẬN DỤNG CƠ BẢN - CHẶN HÀNH ĐỘNG BẰNG NGOẠI LỆ
1. Bối cảnh & Nghiệp vụ:

Bạn quản lý hệ thống E-commerce. Ứng dụng có chức năng Thêm sản phẩm (addProduct).

2. Quy tắc nghiệp vụ:

Chỉ người dùng có vai trò là "ADMIN" mới được phép gọi các hàm thêm dữ liệu (các hàm bắt đầu bằng add*).

3. Vấn đề hiện tại:

Hệ thống đang dùng AOP để kiểm tra quyền, nhưng nó chỉ dùng lệnh in ra màn hình System.out.println để báo lỗi. Hậu quả là dù in ra thông báo "bị từ chối", logic thêm sản phẩm ở phương thức gốc vẫn tiếp tục chạy thành công.

4. Mã nguồn (Hiện trường giả):

@Aspect

@Component

public class SecurityAspect {

    private String currentUserRole = "VIP"; // Giả lập user chỉ là VIP

 

    @Before("execution(* com.example.aopdemo.service.ProductService.add*(..))")

    public void verifyUser(JoinPoint joinPoint) {

        if (!"ADMIN".equals(currentUserRole)) {

            // LỖI LOGIC: Chỉ in cảnh báo, không chặt đứt luồng chạy!

            System.out.println("!! TRUY CẬP BỊ TỪ CHỐI !! User không có quyền.");

        }

    }

}

add vip
    admin



