package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ThongBaoUtil {
    public static void showThongBao(String tieuDe, String noiDung) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(tieuDe);
        alert.setHeaderText(null); // Không có tiêu đề phụ
        alert.setContentText(noiDung);
        alert.showAndWait(); // Hiển thị và chờ người dùng đóng
    }

    public static void showLoi(String noiDung) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Lỗi");
        alert.setHeaderText(null);
        alert.setContentText(noiDung);
        alert.showAndWait();
    }

    public static void showXacNhan(String noiDung, Runnable onXacNhan) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Xác nhận");
        alert.setHeaderText(null);
        alert.setContentText(noiDung);

        alert.showAndWait().ifPresent(response -> {
            if (response.getText().equals("OK")) {
                onXacNhan.run();
            }
        });
    }
}

