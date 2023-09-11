//package personal.api.loan.request
//
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.module.kotlin.KotlinModule
//import personal.api.loan.GenerateKey
//import personal.api.loan.encrypt.EncryptComponent
//import personal.domain.domain.UserInfo
//import personal.domain.repository.UserInfoRepository
//import io.mockk.every
//import io.mockk.mockk
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.DisplayName
//import org.junit.jupiter.api.Test
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.post
//import org.springframework.test.web.servlet.setup.MockMvcBuilders
//
////단위 테스트는 가볍게
//
//@WebMvcTest(LoanRequestController::class)
//internal class LoanRequestControllerTest {
//
//    private lateinit var mockMvc: MockMvc
//
//    private lateinit var loanRequestController: LoanRequestController
//
//    private lateinit var generateKey: GenerateKey
//
//    private lateinit var encryptComponent: EncryptComponent
//
//    private val userInfoRepository: UserInfoRepository = mockk()
//
//    private lateinit var mapper: ObjectMapper
//
//    @MockBean
//    private lateinit var loanRequestServiceImpl: LoanRequestServiceImpl
//
//    companion object{
//        private const val baseUrl = "/fintech/api/v1"
//    }
//
//    @BeforeEach
//    fun init() {
//        generateKey = GenerateKey()
//
//        encryptComponent = EncryptComponent()
//
//        loanRequestServiceImpl = LoanRequestServiceImpl(
//            generateKey, userInfoRepository, encryptComponent
//        )
//        loanRequestController = LoanRequestController(loanRequestServiceImpl)
//
//        mockMvc = MockMvcBuilders.standaloneSetup(loanRequestController).build()
//
//        mapper = ObjectMapper().registerModule(KotlinModule.Builder().build()) //기본 생성자가 없어도 돌아가게 만드는 것
//    }
//
//    @Test
//    @DisplayName("유저 요청이 들어오면 정상 응답을 주어야 한다.")
//    fun testNormalCase() {
//        // given
//        val loanRequestInfoDto: LoanRequestDto.LoanRequestInputDto =
//            LoanRequestDto.LoanRequestInputDto(
//                userName = "TEST",
//                userIncomeAmount = 10000,
//                userRegistrationNumber = "000101-1234567"
//            )
//
//        every { userInfoRepository.save(any()) } returns UserInfo("", "", "", 1)
//
//        // when
//        // then
//        mockMvc.post(
//            "$baseUrl/request"
//        ) {
//            contentType = MediaType.APPLICATION_JSON
//            accept = MediaType.APPLICATION_JSON
//            content = mapper.writeValueAsString(loanRequestInfoDto)
//        }.andExpect {
//            status { isOk() }
//        }
//    }
//}