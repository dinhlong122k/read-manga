// Mã nguồn FlexibleAdapter (Apache-2.0, xem LICENSE trong thư mục này) chép nguyên từ
// https://github.com/arkon/FlexibleAdapter tại commit c80135339bcff5f7f8c2c2380329dfc155b26232
// (đúng bản mà app từng lấy qua JitPack: com.github.arkon.FlexibleAdapter:flexible-adapter:c8013533).
// Lý do đưa vào repo: JitPack không còn trả về artifact này nên build release/CI thất bại.
// Không sửa code bên trong để giữ đúng hành vi cũ.
plugins {
    alias(mihonx.plugins.android.library)
}

android {
    namespace = "eu.davidea.flexibleadapter"

    // Thư viện Java cũ: bỏ qua lint để không chặn build vì cảnh báo của code bên thứ ba.
    lint {
        abortOnError = false
    }
}

dependencies {
    // Code dùng RecyclerView (kéo theo androidx.core và androidx.annotation).
    api(libs.androidx.recyclerView)
}
