package personal.api.loan.review

import personal.domain.domain.LoanReview

interface LoanReviewService {

    fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto

    fun getLoanResult(userKey: String) : LoanReview?

}