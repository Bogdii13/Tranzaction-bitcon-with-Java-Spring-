package ro.zynk.futureup.controllers.responses;

public class ErrorResponse extends BaseResponse {
    private String errorMessage;

    public ErrorResponse() {
        errorMessage = "";
    }

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
