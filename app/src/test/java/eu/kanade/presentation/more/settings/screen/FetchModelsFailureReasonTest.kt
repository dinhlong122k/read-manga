package eu.kanade.presentation.more.settings.screen

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/** [fetchModelsFailureReason]: chọn lý do hiện cho người dùng khi "Lấy danh sách model" thất bại. */
class FetchModelsFailureReasonTest {

    private val noKey = "NO_KEY"

    @Test
    fun `chưa nhập key thì báo thiếu key`() {
        fetchModelsFailureReason(apiKey = "  ", lastError = null, noKeyText = noKey) shouldBe noKey
    }

    @Test
    fun `có lỗi từ server thì hiện nguyên lỗi`() {
        val err = "RuntimeException: HTTP 401 invalid api key"
        fetchModelsFailureReason(apiKey = "sk-1", lastError = err, noKeyText = noKey) shouldBe err
    }

    @Test
    fun `không có lỗi rõ ràng thì trả null`() {
        fetchModelsFailureReason(apiKey = "sk-1", lastError = null, noKeyText = noKey) shouldBe null
        fetchModelsFailureReason(apiKey = "sk-1", lastError = "", noKeyText = noKey) shouldBe null
    }
}
