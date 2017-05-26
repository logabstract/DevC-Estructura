
package pe.com.scotiabank.tbk.payment.util;

public class PaymentWsConstants
{

    public static final String PROPERTIES_FILENAME = "app.properties";
    public static final String KEY_FTP_UPLOAD = "ftp.local.path.upload";
    public static final String METHOD_POST = "POST"; // para descarga de archivos de la parte WEB a SERVICE
    public static final String ERROR_RESPONSE_SERVER_FILES = "ERROR AL CONSULTAR ARCHIVO EN EL SERVIDOR"; // para
                                                                                                          // descarga de
                                                                                                          // archivos de
                                                                                                          // la parte
                                                                                                          // WEB a
                                                                                                          // SERVICE
    public static final String CHARSET_FILE = "utf-8";
    public static final String CONSTANT_ZERO = "0";
    public static final char CONSTANT_ZERO_CHAR = '0';
    public static final char CONSTANT_SPACE_CHAR = ' ';
    public static final String HTTP_INTERNAL_SERVER_ERROR_CODE = "500";

    // TR32
    public static final int TBK_LENGTH_LINE_TR32 = 107;

    // Codigo de tramas
    public static final String TRP0 = "TRP0";
    public static final String TRP1 = "TRP1";
    public static final String TRLD = "TRLD";
    public static final String TRCV = "TRCV";
    public static final String TRVN = "TRVN";
    public static final String TREM = "TREM";
    public static final int TBK_LENGTH_FILE_ROW_TRP1 = 489;
    public static final int TBK_LENGTH_FILE_ROW_TRLO = 85;
    public static final String TBK_TRP1_MULTIPLE_VALUE = "M\u00FAltiples";
    public static final String TBK_TRP1_CURRENT_ACCOUNT = "3";
    public static final String TBK_TRP1_SAVING_ACCOUNT = "2";
    public static final String TBK_TRP1_INTERBANK_ACCOUNT = "4";

    // Fin codigo de tramas

    // reutilizado
    public static final int TBK_PAGE_NUM_ROWS = 25;

    public static final String TBK_ATTR_RETURN_CODE_SUCCESS = "00";

    // FORMATERS
    public static final int FORMAT_NUMBER_DECIMALS = 2;

    public static final String FORMAT_STRING_DATE_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_STRING_DATE_DDMMYYYY = "dd/MM/yyyy";

    // TB2S
    public static final String TB2S = "TB2S";

    // TRLS
    public static final String TRLS = "TRLS";
    public static final int TBK_MAXIMUM_INSTITUTIONS_NUMBER = 25;
    public static final int TBK_ARRAY_LENGHT_INSTITUTIONS = 85;

    public static final int TBK_ATTR_LENGTH_INSTITUTION_NAME = 30;
    public static final int TBK_ATTR_LENGTH_RUC = 11;
    public static final int TBK_ATTR_LENGTH_CATEGORY_TYPE = 1;
    public static final int TBK_ATTR_LENGTH_SERVICE_TYPE = 3;
    public static final int TBK_ATTR_LENGTH_PAGE_ADVANCE = 1;
    public static final int TBK_TRLS_OUTPUT_ATTR_LENGTH_FILLER = 3;
    public static final int TBK_OUTPUT_ATTR_SERVICE_NAME = 30;
    public static final int TBK_OUTPUT_ATTR_ACCOUNT_BT = 9;
    public static final int TBK_OUTPUT_ATTR_COME_FROM = 1;
    public static final int TBK_INPUT_ATTR_LENGTH_QUERY_TYPE = 1;
    public static final int TBK_ATTR_LENGTH_CONTRACT = 5;
    public static final int TBK_ATTR_LENGTH_USER_CODE = 3;
    public static final int TBK_OUTPUT_ATTR_LENGTH_RETURN_CODE = 2;
    public static final int TBK_OUTPUT_ATTR_LENGTH_CONTRACT = 4;
    public static final int TBK_ATTR_LENGTH_CURRENCY = 4;
    public static final int TBK_ATTR_LENGTH_SERVICE_CATEGORY = 3;
    public static final int TBK_OUTPUT_ATTR_LENGTH_INSTITUTION_TYPE = 1;
    public static final int TBK_ATTR_LENGTH_SERVICE_NAME = 20;
    public static final int TBK_ATTR_LENGTH_TELEPHONE_PREFIX = 2;
    public static final int TBK_ATTR_LENGTH_ENTERPRISE = 9;
    public static final int TBK_ATTR_LENGTH_AUTOGENERATE_BRAND = 1;
    public static final int TBK_ATTR_LENGTH_SUPPLY_NUMBER = 20;
    public static final int TBK_ATTR_LENGTH_ERROR_MESSAGE = 50;
    public static final int TBK_ATTR_LENGTH_SESSION_NAME = 20;

    // TB2U
    public static final String TB2U = "TB2U";

    public static final int TBK_ATTR_LENGTH_CUSTOMER_ID_DESCRIPTION = 20;
    public static final int TBK_ATTR_LENGTH_CUSTOMER_ID_MINIMUN = 2;
    public static final int TBK_ATTR_LENGTH_CUSTOMER_ID_MAXIMUM = 2;

    // TB2T
    public static final String TB2T = "TB2T";
    public static final int TBK_TB2T_INPUT_ATTR_LENGTH_ACTION = 1;
    public static final int TBK_TB2T_INPUT_ATTR_LENGTH_AFFILIATION_NUMBER = 20;
    public static final int TBK_TB2T_INPUT_ATTR_LENGTH_CONCEPT = 2;
    public static final int TBK_ATTR_LENGTH_AUTOGENERATE_FLAG = 1;
    public static final int TBK_TB2T_INPUT_ATTR_LENGTH_FIELD_1 = 15;
    public static final int TBK_TB2T_INPUT_ATTR_LENGTH_FIELD_2 = 30;
    public static final int TBK_TB2T_INPUT_ATTR_LENGTH_FIELD_3 = 30;

    public static final String TBK_TRP0_DELETE_FLAG = "E";

    // LEGHT TRAMA TRLD OUTPUT
    public static final int TBK_TRLD_LENGTH_QUANTITY_REGISTRATION = 5;

    // LENGHT TRAMA TRLD FILE OUTPUT
    public static final int TBK_TRLD_LENGTH_CORRELATIVE = 6;
    public static final int TBK_TRLD_LENGTH_TYPE_DOCUMENT = 2;
    public static final int TBK_TRLD_LENGTH_NUMBER_DOCUMENT = 15;
    public static final int TBK_TRLD_LENGTH_EMPLOYEE_CODE = 8;
    public static final int TBK_TRLD_LENGTH_BENEFICIARY = 60;
    public static final int TBK_TRLD_LENGTH_MAIL = 60;
    public static final int TBK_TRLD_LENGTH_REFERENCE = 15;
    public static final int TBK_TRLD_LENGTH_PAYMENT_CONCEPT = 20;
    public static final int TBK_TRLD_LENGTH_DOCUMENT_SIGN = 1;
    public static final int TBK_TRLD_LENGTH_INVOICE_NUMBER = 14;
    public static final int TBK_TRLD_LENGTH_AMOUNT = 15;
    public static final int TBK_TRLD_LENGTH_DATE_EMISSION = 8;
    public static final int TBK_TRLD_LENGTH_DATE_EXPIRATION = 8;
    public static final int TBK_TRLD_LENGTH_SINGLE_PAYMENT = 1;
    public static final int TBK_TRLD_LENGHT_FACTORING_PAYMENT = 1;
    public static final int TBK_TRLD_LENGHT_NON_REMUNERABLE_PAYMENT = 1;
    public static final int TBK_TRLD_LENGHT_WAY_TO_PAY = 1;
    public static final int TBK_TRLD_LENGHT_ACCOUNT = 14;
    public static final int TBK_TRLD_LENGHT_CCI = 20;
    public static final int TBK_TRLD_LENGHT_STATE = 1;
    public static final int TBK_TRLD_LENGHT_DESCRIPTION_ERROR1 = 100;
    public static final int TBK_TRLD_LENGHT_DESCRIPTION_ERROR2 = 100;
    public static final int TBK_TRLD_LENGHT_ERROR_CODE = 4;

    // LENGHT TRAMA TRCV OUTPUT
    public static final int TBK_TRCV_LENGTH_CURRENCY = 4;
    public static final int TBK_TRCV_LENGTH_TOTAL_AMOUNT = 14;
    public static final int TBK_TRCV_LENGTH_TOTAL_QUANTITY = 6;
    public static final int TBK_TRCV_LENGTH_DOCUMENT_OK = 6;
    public static final int TBK_TRCV_LENGTH_TOTAL_OK = 14;
    public static final int TBK_TRCV_LENGTH_WRONG_DOCUMENTS = 6;
    public static final int TBK_TRCV_LENGTH_WRONG_TOTAL = 14;

    // LENGHT TRAMA TRCV FILE OUTPUT
    public static final int TBK_TRCV_LENGTH_REFERENCE = 6;
    public static final int TBK_TRCV_LENGTH_FIELD = 20;
    public static final int TBK_TRCV_LENGTH_MESSAGE = 200;
    public static final int TBK_TRCV_LENGTH_SOLUTION = 30;

    // LENGHT TRAMA TRVN OUTPUT
    public static final int TBK_TRVN_LENGTH_FOUND = 5;
    // LENGHT TRAMA TREM INPUT
    public static final int TBK_TREM_LENGHT_PAYMENT_TYPE = 2;
    public static final int TBK_TREM_LENGHT_TEMPLATE = 5;
    public static final int TBK_TREM_LENGHT_CHARGE_ACCOUNT = 20;
    public static final int TBK_TREM_LENGHT_PROCESS_DATE = 8;
    public static final int TBK_TREM_LENGHT_CHARGE_CURRENCY = 4;
    public static final int TBK_TREM_LENGHT_CHARGE_AMOUNT = 11;
    public static final int TBK_TREM_LENGHT_CHARGE_AMOUNT_DECIMALS = 2;
    public static final int TBK_TREM_LENGHT_USER = 2;
    public static final int TBK_TREM_LENGHT_USERNAME = 20;
    public static final int TBK_TREM_LENGHT_RECORD_COUNT = 5;
    public static final String TBK_TREM_LENGHT_MEMBER_UPLOAD_CHAR = "S";
    public static final int TBK_TREM_LENGHT_REFERENCE = 30;
    public static final int TBK_TREM_LENGHT_PROCESS_INDICATOR = 1;

    // LENGHT TRAMA TREM OUTPUT
    public static final int TBK_TREM_LENGHT_MEMBER = 20;
    public static final int TBK_TREM_LENGHT_TOTAL_RECORD_COUNT = 5;
    public static final int TBK_TREM_LENGHT_ERR_RECORD_COUNT = 5;
    public static final int TBK_TREM_LENGHT_TOTAL_RECORD_AMOUNT = 11;
    public static final int TBK_TREM_LENGHT_TOTAL_ERR_RECORD_AMOUNT = 11;

    // LENGHT TRAMA TREM FILE OUTPUT
    public static final int TBK_TREM_LENGHT_LINE = 5;
    public static final int TBK_TREM_LENGHT_ERROR_TYPE = 1;
    public static final int TBK_TREM_LENGHT_ERROR_FIELD = 50;
    public static final int TBK_TREM_LENGHT_ERROR_DESC = 50;
    public static final int TBK_TREM_LENGHT_SOLUTION_HINT = 50;

    public static final String TBK_TREM_FILE_DOWNLOAD_PREFIX = "LTWW01X.";
    public static final String TBK_TREM_FILE_UPLOAD_PREFIX = "LTWW08X.";

    public static final String TBK_TREM_VALIDATION_FLAG = "S";
    public static final String TBK_TREM_SCHEDULE_FLAG = "N";
    public static final String TBK_TREM_ZIP_FORMAT = "zip";
    public static final String TBK_TREM_TXT_FORMAT = "txt";
    public static final String TBK_TREM_TEMPFILE_EXTENSION = ".tmp";

    public static final String TBK_TB2S_QUERY_TYPE = "S";
    public static final String TBK_TB2U_QUERY_TYPE = "U";
    public static final String TBK_TB2T_QUERY_TYPE = "T";
    public static final String TBK_TB2W_QUERY_TYPE = "W";

    public static final String TBK_TB2T_INSERT_SERVICE = "I";
    public static final String TBK_TB2T_DELETE_SERVICE = "E";

    public static final String TRPO = "TRPO";
    public static final int TBK_TRPO_LENGTH_ORDER_TYPE = 3;
    public static final int TBK_TRPO_LENGTH_USER_CREATE_ORDER = 3;
    public static final int TBK_TRPO_LENGHT_STATE = 1;
    public static final int TBK_TRPO_LENGHT_CORRELATIVE = 6;
    public static final int TBK_TRPO_LENGHT_USER_DETAIL = 3;
    public static final int TBK_TRPO_LENGTH_DOCUMENT_TYPE = 2;
    public static final int TBK_TRPO_LENGTH_DOCUMENT_NUMBER = 15;
    public static final int TBK_TRPO_LENGTH_EMPLOYEE_CODE = 8;
    public static final int TBK_TRPO_LENGTH_BENEFICIARY = 60;
    public static final int TBK_TRPO_LENGTH_EMAIL = 60;
    public static final int TBK_TRPO_LENGTH_REFERENCE_PV = 15;
    public static final int TBK_TRPO_LENGTH_PAYMENT_CONCEPT = 20;
    public static final int TBK_TRPO_LENGTH_DOCUMENT_SIGN = 1;
    public static final int TBK_TRPO_LENGTH_INVOICE_NUMBER = 14;
    public static final int TBK_TRPO_LENGTH_AMOUNT = 15;
    public static final int TBK_TRPO_LENGTH_SINGLE_PAYMENT = 1;
    public static final int TBK_TRPO_LENGTH_FACTORY_PAYMENT = 1;
    public static final int TBK_TRPO_LENGTH_NO_PAYMENT = 1;
    public static final int TBK_TRPO_LENGTH_PAYMENT_METHOD = 1;
    public static final int TBK_TRPO_LENGTH_ACCOUNT = 14;
    public static final int TBK_TRPO_LENGTH_CCI = 20;
    public static final String TBK_TRPO_ACTION_DELETE = "E";
    public static final int TBK_TRPO_LENGTH_DUE_DATE = 8;
    public static final int TBK_TRPO_LENGTH_INVOICE_DATE = 8;

    public static final String TB2W = "TB2W";
    public static final int TBK_TB2W_LENGTH_TOLD_NUMBER = 7;
    public static final int TBK_TB2W_LENGTH_CREDIT_CARD = 8;
    public static final int TBK_TB2W_LENGTH_DOCUMENT_TO_PAY = 20;
    public static final int TBK_TB2W_LENGTH_RECEIPT = 20;
    public static final int TBK_LENGTH_DATE = 8;
    public static final int TBK_TB2W_LENGTH_AMOUNT = 15;
    public static final int TBK_TB2W_LENGTH_CHRONOLOGICAL_FLAG = 1;
    public static final int TBK_TB2W_LENGTH_PARTIAL_FLAG = 1;
    public static final int TBK_TB2W_LENGTH_CONCEPT = 2;
    public static final int TBK_TB2W_LENGTH_MINIMUM_AMOUNT = 14;
    public static final int TBK_TB2W_LENGTH_FIELD_1 = 15;
    public static final int TBK_TB2W_LENGTH_FIELD_2 = 30;
    public static final int TBK_TB2W_LENGTH_FIELD_3 = 30;
    public static final int TBK_TB2W_LENGTH_MASK = 1;
    public static final int TBK_TB2W_LENGTH_MESSAGE_CODRET = 50;
    public static final int TBK_TB2W_LENGTH_CHRONOLOGICAL_CODRET = 2;
    public static final int TBK_TB2W_DECIMAL_NUMBER_AMOUNT = 2;
    public static final String TBK_UPLOAD_FILE = "S";
    public static final String TBK_TB2W_FILE_UPLOAD_PREFIX = "LTWW01X.";
    public static final String TBK_TB2W_WITHOUT_SIGN = "";

    public static final String TRSG = "TRSG";
    public static final int TBK_TRSG_LENGTH_ORDER = 5;
    public static final int TBK_TRSG_LENGTH_PAYMENT_TYPE = 2;
    public static final String TBK_TRSG_INVOKE = "N";
    public static final int TBK_TRSG_LENGTH_CHARGE_ACCOUNT = 14;
    public static final int TBK_TRSG_LENGTH_REFERENCE = 15;
    public static final int TBK_TRSG_LENGTH_RECEIPT_TOTAL = 6;
    public static final int TBK_TRSG_LENGTH_CONTRACT_HEADER = 4;
    public static final int TBK_TRSG_LENGTH_ORDER_HEADER = 4;
    public static final int TBK_TRSG_HEADER_LENGTH_ACCOUNT_PAYMENT = 4;
    public static final String TBK_TRSG_HEADER_ELEVEN_ZEROS = "00000000000";
    public static final int TBK_TRSG_HEADER_LENGTH_CHEQUE_PAYMENT = 4;
    public static final int TBK_TRSG_HEADER_LENGTH_TOTAL = 11;
    public static final int TBK_TRSG_HEADER_LENGTH_CURRENCY = 2;
    public static final int TBK_TRSG_HEADER_LENGTH_OFFICE = 3;
    public static final int TBK_TRSG_HEADER_LENGTH_CODE_ACCOUNT = 7;
    public static final int TBK_TRSG_HEADER_LENGTH_SECURITY_CODE_MODULE = 2;
    public static final int TBK_TRSG_HEADER_LENGTH_SECURITY_CODE = 2;
    public static final int TBK_TRSG_HEADER_LENGTH_TIME = 6;
    public static final String TBK_TRSG_HEADER_TYPE = "B";
    public static final int TBK_TRSG_HEADER_LEGTH_ACCOUNT_TYPE = 1;
    public static final String TBK_TRSG_HEADER_ONE_ZERO = "0";
    public static final int TBK_TRSG_HEADER_LEGTH_HIGHER_PAYMENT = 11;
    public static final int TBK_TRSG_HEADER_LEGTH_ELEVEN_SPACES = 11;
    public static final String TBK_TRSG_HEADER_TWO_ZEROS = "00";
    public static final int TBK_TRSG_HEADER_LEGTH_COMPANY_SEQUENCE = 3;
    public static final int TBK_TRSG_HEADER_LEGTH_USER = 2;
    public static final String TBK_TRSG_HEADER_CODE = "0000 E";
    public static final int TBK_TRSG_HEADER_LEGTH_PAYMENTS_QUANTITY = 4;
    public static final int TBK_TRSG_HEADER_LEGTH_REFERENCE = 15;
    public static final int TBK_TRSG_HEADER_FIFTEEN_SPACES = 15;
    public static final int TBK_TRSG_HEADER_ONE_SPACE = 1;
    public static final int TBK_TRSG_HEADER_TWENTY_ONE_SPACES = 21;
    public static final String TBK_TRSG_HEADER_TWELVE_ZEROS = "000000000000";
    public static final String TBK_TRSG_HEADER_ZERO_WITH_SPACE = "0 ";
    public static final String TBK_TRSG_HEADER_FIVE_ZEROS = "00000";
    public static final int TBK_TRSG_HEADER_LENGTH_ACCOUNT_PAYMENT_2 = 5;
    public static final int TBK_TRSG_HEADER_LENGTH_CHEQUE_PAYMENT_2 = 5;
    public static final int TBK_TRSG_HEADER_EIGHT_SPACES = 8;
    public static final int TBK_TRSG_HEADER_LEGTH_USER_NAME = 20;
    public static final int TBK_TRSG_HEADER_TWENTY_SPACES = 20;
    public static final int TBK_TRSG_HEADER_SEVEN_SPACES = 7;
    public static final String TBK_TRSG_DETAIL_TYPE = "B";
    public static final String TBK_TRSG_DETAIL_TWO_ZEROS = "00";
     public static final String TBK_EMPTY = "";
    public static final int TBK_TRSG_SERVICE_NAME = 30;
    public static final int TBK_TRSG_DETAIL_SECOND_RECEIBT_NUMBER = 6;
    public static final int TBK_TRSG_DETAIL_TWO_SPACES = 2;
    public static final int TBK_TRSG_DETAIL_FIRST_RECEIBT_NUMBER = 14;
    public static final int TBK_TRSG_DETAIL_SUPPLY_CODE = 20;
    public static final int TBK_TRSG_DETAIL_AMOUNT = 11;
    public static final int TBK_TRSG_DETAIL_SIX_SPACES = 6;
    public static final int TBK_TRSG_DETAIL_TWENTY_SPACES = 20;
    public static final int TBK_TRSG_DETAIL_LEGTH_CURRENCY = 2;
    public static final String TBK_TRSG_DETAIL_PAYMENT_FORM = "1";
    public static final int TBK_TRSG_DETAIL_LEGTH_SERVICE_TYPE = 3;
    public static final String TBK_TRSG_DETAIL_ACCOUNT_CODE = "0000000";
    public static final int TBK_TRSG_DETAIL_LEGTH_SECURITY_CODE = 2;
    public static final String TBK_TRSG_DETAIL_CONSTANT_TWO = "2";
    public static final int TBK_TRSG_DETAIL_LEGTH_OFFICE = 3;
    public static final int TBK_TRSG_DETAIL_LEGTH_ACCOUNT_CODE = 7;
    public static final String TBK_TRSG_DETAIL_CONSTANT_NINE_WITH_SPACE = "9 ";
    public static final String TBK_TRSG_DETAIL_CONSTANT_ASTERISK = "*";
    public static final int TBK_TRSG_DETAIL_ONE_SPACE = 1;
    public static final int TBK_TRSG_DETAIL_SEVEN_SPACES = 7;
    public static final int TBK_TRSG_DETAIL_SIXTEEN_SPACES = 16;
    public static final int TBK_TRSG_DETAIL_FIFTEEN_SPACES = 15;
    public static final int TBK_TRSG_DETAIL_EIGTH_SPACES = 8;
    public static final int TBK_TRSG_DETAIL_THIRTY_SPACES = 30;
    public static final int TBK_TRSG_DETAIL_FOUR_SPACES = 4;
    public static final String TBK_TRSG_DETAIL = " ";
    public static final String TBK_TRSG_NET = "+";
    public static final int TBK_TRSG_DETAIL_TWELVE_SPACES = 12;
    public static final String TBK_LINE_JUMP = "\n";
    public static final String TBK_TRSG_FILE_UPLOAD_HEADER_PREFIX = "LTWW01X.";
    public static final String TBK_TRSG_FILE_UPLOAD_DETAIL_PREFIX = "LTWW02X.";
    public static final char TBK_TRSG_PREFIX_MEMBER = 'S';

    // TRE0 Input
    public static final int TBK_ATTR_LENGTH_USER_MASTER = 3;
    public static final int TBK_ATTR_LENGTH_COMPANY_SECUENCE = 3;
    public static final int TBK_ATTR_LENGTH_TYPEDOCUMENT = 2;
    public static final int TBK_ATTR_LENGTH_NUMBER_DOCUMENT = 15;
    public static final int TBK_ATTR_LENGTH_FLAG = 1;
    public static final int TBK_ATTR_LENGTH_COMPANY_CODE = 8;
    public static final int TBK_ATTR_LENGTH_COMPANY_NAME = 60;
    public static final int TBK_ATTR_LENGTH_NATIONAL_PAYMENT_FORM1 = 1;
    public static final int TBK_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE1 = 14;
    public static final int TBK_ATTR_LENGTH_CCI_NATIONAL1 = 20;
    public static final int TBK_ATTR_LENGTH_NATIONAL_PAYMENT_FORM2 = 1;
    public static final int TBK_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE2 = 14;
    public static final int TBK_ATTR_LENGTH_CCI_NATIONAL2 = 20;
    public static final int TBK_ATTR_LENGTH_NATIONAL_PAYMENT_FORM3 = 1;
    public static final int TBK_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE3 = 14;
    public static final int TBK_ATTR_LENGTH_CCI_NATIONAL3 = 20;
    public static final int TBK_ATTR_LENGTH_INTERNATIONAL_PAYMENT_FORM1 = 1;
    public static final int TBK_ATTR_LENGTH_INTERNATIONAL_ACCOUNT_CODE1 = 14;
    public static final int TBK_ATTR_LENGTH_CCI_INTERNATIONAL1 = 20;
    public static final int TBK_ATTR_LENGTH_INTERNATIONAL_PAYMENT_FORM2 = 1;
    public static final int TBK_ATTR_LENGTH_INTERNATIONAL_ACCOUNT_CODE2 = 14;
    public static final int TBK_ATTR_LENGTH_CCI_INTERNATIONAL2 = 20;
    public static final int TBK_ATTR_LENGTH_INTERNATIONAL_PAYMENT_FORM3 = 1;
    public static final int TBK_ATTR_LENGTH_INTERNATIONAL_ACCOUNT_CODE3 = 14;
    public static final int TBK_ATTR_LENGTH_CCI_INTERNATIONAL3 = 20;
    public static final int TBK_ATTR_LENGTH_CURRENCY_CTS = 4;
    public static final int TBK_ATTR_LENGTH_CTS_CCI = 20;
    public static final int TBK_ATTR_LENGTH_CTS_CTA = 14;
    public static final int TBK_ATTR_LENGTH_TYPE_CTS = 1;

    // TRE1 input
    public static final int TBK_OUPUT_ATTR_LENGTH_TYPE_DOCUMENT = 2;
    public static final int TBK_OUPUT_ATTR_LENGTH_DESCRIPTION_TYPE_DOCUMENT = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_NUMBER_DOCUMENT = 15;
    public static final int TBK_OUPUT_ATTR_LENGTH_EMPLOYEE_CODE = 8;
    public static final int TBK_OUPUT_ATTR_LENGTH_EMPLOYEE_NAME = 60;
    public static final int TBK_OUPUT_ATTR_LENGTH_NATIONAL_PAYMENT_FORM1 = 1;
    public static final int TBK_OUPUT_ATTR_LENGTH_NAME_NATIONAL_ACCOUNT_CODE1 = 16;
    public static final int TBK_OUPUT_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE1 = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_CCI_NATIONAL1 = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_NATIONAL_PAYMENT_FORM2 = 1;
    public static final int TBK_OUPUT_ATTR_LENGTH_NAME_NATIONAL_ACCOUNT_CODE2 = 16;
    public static final int TBK_OUPUT_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE2 = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_CCI_NATIONAL2 = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_NATIONAL_PAYMENT_FORM3 = 1;
    public static final int TBK_OUPUT_ATTR_LENGTH_NAME_NATIONAL_ACCOUNT_CODE3 = 16;
    public static final int TBK_OUPUT_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE3 = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_CCI_NATIONAL3 = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_FOREIGN_PAYMENT_FORM1 = 1;
    public static final int TBK_OUPUT_ATTR_LENGTH_NAME_FOREIGN_ACCOUNT_CODE1 = 16;
    public static final int TBK_OUPUT_ATTR_LENGTH_FOREIG_NACCOUNT_CODE1 = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_CCI_FOREIGN1 = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_FOREIGN_PAYMENT_FORM2 = 1;
    public static final int TBK_OUPUT_ATTR_LENGTH_NAME_FOREIG_NACCOUNT_CODE2 = 16;
    public static final int TBK_OUPUT_ATTR_LENGTH_FOREIGN_ACCOUNT_CODE2 = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_CCI_FOREIGN2 = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_FORE_IGNPAYMENT_FORM3 = 1;
    public static final int TBK_OUPUT_ATTR_LENGTH_NAME_FOREIGN_ACCOUNT_CODE3 = 16;
    public static final int TBK_OUPUT_ATTR_LENGTH_FORE_IGNACCOUNT_CODE3 = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_CCCI_FOREIGNTS3 = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_MODIFICATION_DATE = 8;
    public static final int TBK_OUPUT_ATTR_LENGTH_MODIFICATION_HOUT = 8;
    public static final int TBK_OUPUT_ATTR_LENGTH_CURRENCY_CTS = 4;
    public static final int TBK_OUPUT_ATTR_LENGTH_CTS_CCI = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_CTS_CTA = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_TYPE_CTS = 1;

    // mensaje
    public static final int TBK_OUPUT_ATTR_LENGTH_MESSAGE = 50;

    // TRE1
    public static final int TBK_OUPUT_ATTR_LENGTH_SESSION_FILE_NAME = 20;
    public static final int TBK_OUPUT_ATTR_LENGTH_COMPANY_QUANTITY = 3;

    // Longitud de filas
    public static final int TBK_OUPUT_ATTR_LENGTH_NUMBER_FILES = 5;

    // TB56Input
    public static final int TBK_ATTR_LENGTH_AGREEMENT = 5;
    public static final int TBK_ATTR_LENGTH_SEQUENCE = 3;
    public static final int TBK_ATTR_LENGTH_NUMBER_PAGE = 5;

    // TROP
    public static final int TBK_OUPUT_ATTR_LENGTH_ORDER = 5;
    public static final int TBK_OUPUT_ATTR_LENGTH_AMOUNT_DATE = 8;
    public static final int TBK_OUPUT_ATTR_LENGTH_ACCOUNT_TITLE = 14;
    public static final int TBK_OUPUT_ATTR_LENGTH_REFERENCE = 15;
    public static final int TBK_OUPUT_ATTR_LENGTH_SCHEDULED_DATE = 8;

    // TROP
    public static final int TBK_OUPUT_ATTR_LENGTH_RETURN_CODE = 4;
    public static final int TBK_OUPUT_ATTR_LENGTH_ACCOUNT = 14;
    public static final String TROP = "TROP";
    // TRE0
    public static final String TRE0 = "TRE0";
    public static final String TRE1 = "TRE1";

    public static final String TBK_SUCCESS_MESSAGE = "El servicio obtuvo la informaci\u00F3n de forma exitosa";

    // TRRO
    public static final int TBK_OUPUT_ATTR_LENGTH_CONTRACT = 5;
    public static final int TBK_OUPUT_ATTR_LENGTH_USER_CODE = 3;
    public static final int TBK_OUPUT_ATTR_LENGTH_ORDER_NEW = 5;
    public static final String TBK_TRRO_RESPONSE_SUCCESS_MESSAGE_COPY = "Se copio orden correctamente.";
    public static final String TBK_TRRO_RESPONSE_ERROR_INVALID_DATA = "Datos invalidos.";
    public static final String TBK_TRRO_DATA_ERROR_INVALID = "0629";
    public static final String TBK_TRRO_RESPONSE_ERROR_DUPLICATE_ORDER = "Orden duplicada.";
    public static final String TBK_TRRO_DATA_ERROR_DUPLICATE_ORDER = "0001";
    public static final String TBK_TRRO_DATA_ERROR_RECORD_DUPLICATE_DETAIL = "Registro con detalle duplicado.";
    public static final String TBK_TRRO_DATA_ERROR_DUPLICATE_DETAIL = "0003";
    public static final String TBK_TRRO_RESPONSE_ERROR_DATE = "Datos incorrectos";

    public static final String TRRO = "TRRO";

    // TBBC
    public static final String TBBC = "TBBC";
    public static final int TBK_TBBC_ATTR_LENGTH_BT_ACCOUNT = 12;
    public static final int TBK_TBBC_ATTR_LENGTH_INDICATOR = 1;

    // TRP0
    public static final String ACCOUNT_TYPE_SAVING = "2";
    public static final String ACCOUNT_TYPE_CURRENT = "3";
    public static final String MONEY_SOLES = "0000";
    public static final String MONEY_DOLARS = "0001";

    // TRVC
    public static final String TRVC = "TRVC";
    public static final int TBK_TRVC_ATTR_LENGTH_OFFICE = 3;
    public static final int TBK_TRVC_ATTR_LENGTH_ACCOUNT_CODE = 7;
    public static final int TBK_TRVC_ATTR_LENGTH_ACCOUNT_TYPE = 1;
    public static final int TBK_TRVC_ATTR_LENGTH_CURRENCY = 4;

    public static final int TBK_TRVC_ATTR_LENGTH_DOCUMENT_TYPE = 2;
    public static final int TBK_TRVC_ATTR_LENGTH_DOCUMENT_NUMBER = 12;
    public static final int TBK_TRVC_ATTR_LENGTH_ACCOUNTS_NUMBER = 1;
    public static final int TBK_TRVC_ATTR_LENGTH_CTS = 14;

    public static final int TBK_TRVC_ATTR_LENGTH_EXIST = 1;
    public static final int TBK_TRVC_ATTR_LENGTH_BT_ACCOUNT = 9;
    public static final int TBK_TRVC_ATTR_LENGTH_EQUIVALENT_ACCOUNT = 14;
    public static final int TBK_TRVC_ATTR_LENGTH_ORIGIN = 1;
    public static final int TBK_TRVC_ATTR_LENGTH_RETURN_CODE = 4;

    public static final int TBK_TRVC_MAXIMUM_ACCOUNTS_NUMBER = 7;
    public static final int TBK_TRVC_SIZE_LENGTH_ACCOUNT = 29;
    public static final int TBK_INPUT_TRVC_MAXIMUM_ACCOUNTS_NUMBER = 6;

    public static final String TBK_TRVC_MESSAGE_ERROR = "No cumple con la validacion, revisar cuentas";
    // TB83
    public static final int TBK_TB83_LENGTH_BT_ACCOUNT = 9;
    public static final int TBK_TB83_LENGTH_SERVICE_CODE = 3;
    public static final int TBK_TB83_OUTPUT_PAYROLL_DATA_LIST_SIZE = 10;
    public static final int TBK_TB83_OUTPUT_PAYROLL_DATA_LENGTH_TRAMA = 239;
    public static final int TBK_TB83_PAYAUTOGENERATED_DATA_LIST_SIZE = 40;
    public static final int TBK_TB83_PAYAUTOGENERATED_DATA_LENGTH_TRAMA = 57;
    public static final int TBK_TB83_LENGTH_PAGE_INDICATOR = 20;
    public static final int TBK_TB83_LENGTH_AUTOGENERATED_TITLE = 15;
    public static final int TBK_TB83_LENGTH_MAIN_TITLE = 15;
    public static final int TBK_TB83_LENGTH_REFERENCE_TITLE = 15;
    public static final int TBK_TB83_LENGTH_CODE_VALIDATION = 1;
    public static final int TBK_TB83_LENGTH_CODE_CONCEPT = 2;
    public static final int TBK_TB83_LENGTH_DESCRIPTION_CONCEPT = 30;
    public static final int TBK_TB83_LENGTH_IMPORT_CONCEPT = 10;
    public static final int TBK_TB83_LENGTH_PARTIAL_PAYMENT = 1;
    public static final int TBK_TB83_LENGTH_CURRENCY_CONCEPT = 4;
    public static final int TBK_TB83_LENGTH_MINIMUM_CONCEPT_AMOUNT = 10;
    public static final String TB83 = "TB83";
    public static final String KEY_FTP = "ftp.local.path";

    // TRLO
    public static final String TRLO = "TRLO";
    public static final int TBK_TRLO_LENGTH_ORDER_TYPE = 2;
    public static final int TBK_TRLO_LENGTH_CURRENCY = 4;
    public static final int TBK_TRLO_LENGTH_SESSION_NAME = 20;
    public static final int TBK_TRLO_LENGTH_FILES_QUANTITY = 5;
    public static final int TBK_TRLO_LENGTH_ORDER = 5;
    public static final int TBK_TRLO_LENGTH_DATE_GENERATION = 8;
    public static final int TBK_TRLO_LENGTH_USER_CREATE_ORDER = 2;
    public static final int TBK_TRLO_LENGTH_TOTAL_AMOUNT = 15;
    public static final int TBK_TRLO_LENGTH_STATE = 1;
    public static final int TBK_TRLO_LENGTH_DOCUMENTS_TOTAL = 6;
    public static final int TBK_TRLO_LENGTH_DOCUMENTS_TOTAL_OK = 6;
    public static final int TBK_TRLO_LENGTH_DOCUMENTS_TOTAL_ERROR = 6;
    public static final int TBK_TRLO_LENGTH_AMOUNT_OK = 15;
    public static final int TBK_TRLO_LENGTH_AMOUNT_ERROR = 15;
    public static final String TBK_TRPE_FILE_MESSAGE_1 = "NO TIENE DATOS EL ARCHIVO";
    public static final String TBK_TRPE_FILE_MESSAGE_2 = "PROBLEMAS CON EL ARCHIVO";

    // TRPE
    public static final String TRPE = "TRPE";
    public static final int TBK_TRPE_LENGTH_ORDER = 5;
    public static final int TBK_TRPE_LENGTH_PAYMENT_TYPE = 2;
    public static final int TBK_TRPE_LENGTH_CONTRACT = 4;
    public static final String TBK_TRPE_ATTR_INVOKE = "S";

    public static final String CONSTANT_STATE = "Estados";
    public static final String CONSTANT_CHANGED_STATE = "#Xstados";
    public static final String CONSTANT_NOTES = "Notas";
    public static final String CONSTANT_CHANGED_NOTES = "#Xotas";
    public static final String CONSTANT_X_STATE = "Xstados";
    public static final String CONSTANT_X_NOTES = "Xotas";
    public static final String CONSTANT_PDF_URL_DEFAULT = "http://[IP]/odwek/retrieve.php?param[#]_folder|tipodoc|_docid&valor[#][FOLDER]|.pdf|[FLAG]";
    public static final String CONSTANT_ESTADO_CUENTA = "Estados%20de%20Cuenta";
    public static final String CONSTANT_NOTA_OPERACION = "Notas%20de%20Operacion";
    public static final String CONSTANT_NOTA_CONSOLIDADA = "Notas%20Consolidadas";
    public static final String CONSTANT_LINE = "|";
    public static final String CONSTANT_20_NULL = "%20";
    public static final String CONSTANT_NULL = "";
    public static final String CONSTANT_NUMERAL = "#";
    public static final String CONSTANT_FLAG = "[FLAG]";
    public static final String CONSTANT_ONE = "1";
    public static final String CONSTANT_TWO = "2";
    public static final String CONSTANT_THREE = "3";
    public static final String CONSTANT_IP = "[IP]";
    public static final String CONSTANT_FOLDER = "[FOLDER]";
    public static final String CONSTANT_DATE1 = "[DATE1]";
    public static final String CONSTANT_DATE2 = "[DATE2]";
    public static final String CONSTANT_DOCID = "[DOCID]";
    public static final String CONSTANT_CTA = "[CTA]";
    public static final String CONSTANT_CTABT = "[CTABT]";
    public static final String CONSTANT_NUM = "[#]";
    public static final String DEFAULT_URL = "http://[IP]/odwek/search.php?param[#]_folder|Documento%20Identidad|Cuenta|Cuenta%20BT|DATE1|DATE2&valor[#][FOLDER]|[DOCID]|[CTA]|[CTABT]|[DATE1]|[DATE2]";
    public static final String CONSTANT_ACCOUNT_STATE = "Estados%20de%20Cuenta";
    public static final String CONSTANT_OPERATION_NOTES = "Notas%20de%20Operacion";
    public static final String CONSTANT_CONSOLIDATED_NOTES = "Notas%20Consolidadas";
    public static final String CONSTANT_URL_IN_TBNC = "ODWEK Search DOC. IN: ";
    public static final String CONSTANT_URL_OUT_TBNC = "ODWEK Search DOC. OUT: ";
    public static final String CONSTANT_PDF_IN_TBNC = "ODWEK Retrieve DOC. IN: ";
    public static final String CONSTANT_PDF_OUT_TBNC = "ODWEK Retrieve DOC. OUT: ";
    public static final String CONSTANT_UTF_FORMAT = "UTF-8";
    public static final String CONSTANT_REQUEST_METHOD = "POST";
    public static final String CONSTANT_FIRST_COMBO = "1";
    public static final String CONSTANT_SECOND_COMBO = "2";
    public static final String CONSTANT_THIRD_COMBO = "3";
    public static final String CONSTANT_REQUEST_PROPERTY = "Content-Type";
    public static final String CONSTANT_REQUEST_PROPERTY_CHARSET = "charset";
    public static final String CONSTANT_REQUEST_PROPERTY_UTF = "utf-8";
    public static final String CONSTANT_REQUEST_PROPERTY_APPLICATION = "application/x-www-form-urlencoded";
    public static final String CONSTANT_BLANK_SPACE = "%20";
    public static final String CONSTANT_EQUAL = "=";
    public static final String CONSTANT_RETURN_CODE_OK = "00";
    public static final int NUM_ZERO = 0;
    public static final int NUM_ONE = 1;
    public static final int NUM_TWO = 2;
    public static final int NUM_THREE = 3;
    public static final int NUM_FOUR = 4;
    public static final int NUM_FIVE = 5;
    public static final int NUM_SIX = 6;
    public static final int NUM_SEVEN = 7;
    public static final int NUM_EIGHT = 8;
    public static final int NUM_NINE = 9;
    public static final int NUM_TEN = 10;
    public static final int NUM_ELEVEN = 11;
    public static final String CONSTANT_PRINT = "mprimir";
    public static final String CHARSET_FILE_UTF8 = "Utf-8";
    public static final String CHARSET_FILE_ANSI = "Cp1252";
    public static final int TBK_LENGHT_HEADER = 100;
    public static final int TBK_LENGHT_ERROR_MESSAGE = 50;
    public static final int TBK_OUTPUT_INDEX_ERROR_MESSAGE_150 = 150;
    public static final String TBK_SUCCESS_CODE = "0000";

    // TRLD WAY TO PAY MESSAGES
    public static final String TBK_TRLD_WAYTOPAY_1 = "Pago con cheque de gerencia";
    public static final String TBK_TRLD_WAYTOPAY_2 = "Abono en cuenta de ahorros";
    public static final String TBK_TRLD_WAYTOPAY_3 = "Abono en cuenta corriente";
    public static final String TBK_TRLD_WAYTOPAY_4 = "Abono en CCI de otro banco local";
    public static final String TBK_TRLD_TEXT_SINGLEPAYMENT = "Si";
    public static final String TBK_TRVN_ERROR_CODE1 = "0185";
    public static final String TBK_TRVN_ERROR_CODE2 = "0186";
    public static final String TBK_TRVN_ERROR_CODE3 = "0187";
    public static final String TBK_TRVN_ERROR_MESSAGE1 = "La orden ya existe en Pre-Ordenes";
    public static final String TBK_TRVN_ERROR_MESSAGE2 = "La orden ya existe en Pre-Ordenes";
    public static final String TBK_TRVN_ERROR_MESSAGE3 = "La orden ya existe en Pre-Ordenes";

    // INPUT TRE1
    public static final int TBK_OUPUT_ATTR_LENGTH_NUMBER_PAGE = 15;
    public static final int TBK_OUPUT_ATTR_LENGTH_NUMBER_DOCUMENT_DOC = 2;

    // TRNP
    public static final int TBK_OUTPUT_LENGTH_ORDER = 5;
    public static final int TBK_INPUT_LENGTH_RETURN_CODE = 4;
    public static final String TRPN = "TRPN";

    // TRP1 - SEARCH
    public static final int TBK_TRP1_INIT_POSITION_DOCUMENT_NUMBER = 3;
    public static final int TBK_TRP1_MAXIMUM_LENGTH_DOCUMENT_NUMBER = 15;
    public static final int TBK_TRP1_INIT_POSITION_BENEFACTOR = 18;
    public static final int TBK_TRP1_MAXIMUM_LENGTH_BENEFACTOR = 60;

    public static final int TBK_TRP1_INIT_POSITION_PAYMENT_METHOD_MN_1 = 156;
    public static final int TBK_TRP1_INIT_POSITION_SAB_CODE = 486;
    public static final int TBK_TRP1_MAXIMUM_LENGTH_PAYMENT_METHOD_MN_1 = 1;
    public static final int TBK_TRP1_MAXIMUM_LENGTH_SAB_CODE = 4;
    public static final int TBK_TRP1_CHARACTERS_BETWEEN_PAYMENT_METHOD = 55;
    public static final int TBK_TRP1_PAYMENT_METHOD_NUMBER = 6;

    public static final int TBK_TREM_LENGHT_MANAGEMENTCHECKSCOUNT = 5;
    public static final int TBK_TREM_LENGHT_MANAGEMENTCHECKSAMOUNT = 11;
    public static final int TBK_TREM_LENGHT_CREDITACCOUNTSCOUNT = 5;
    public static final int TBK_TREM_LENGHT_CREDITACCOUNTSAMOUNT = 11;
    public static final int TBK_TREM_LENGHT_CREDITACCOUNTSOTHERBANKSCOUNT = 5;
    public static final int TBK_TREM_LENGHT_CREDITACCOUNTSOTHERBANKSAMOUNT = 11;
    public static final int TBK_TREM_LENGHT_CREDITNOTESCOUNT = 5;
    public static final int TBK_TREM_LENGHT_CREDITNOTESAMOUNT = 11;

    // TRE1 - SEARCH
    public static final int TBK_TRE1_INIT_POSITION_DOCUMENT_NUMBER = 23;
    public static final int TBK_TRE1_MAXIMUM_LENGTH_DOCUMENT_NUMBER = 15;
    public static final int TBK_TRE1_INIT_POSITION_EMPLOYEE_NAME = 46;
    public static final int TBK_TRE1_MAXIMUM_LENGTH_BENEFACTOR = 60;

    // TRPE
    public static final int TBK_TRPE_LENGTH_ORDERS_NUMBER = 2;
    public static final int TBK_TREM_NUMBER_DECIMALS = 2;

    public static final String FORMAT_INIT_DATE = "dd/MM/yyyy";
    public static final String FORMAT_FINAL_DATE = "yyyyMMdd";

    // TRP2
    public static final String TRP2 = "TRP2";
    public static final String TBK_TRP2_PREFIX_MEMBER = "C";
    public static final int TBK_TRP2_ATTR_LENGTH_USER_CODE = 4;
    public static final int TBK_TRP2_ATTR_LENGTH_MEMBER = 20;
    public static final int TBK_TRP2_ATTR_LENGTH_MESSAGE = 100;
    public static final int TBK_TRP2_ATTR_LENGTH_REGISTERS_NUMBER_OK = 6;
    public static final int TBK_TRP2_ATTR_LENGTH_REGISTERS_NUMBER_ERROR = 6;

    public static final int TBK_TRP2_ATTR_LENGTH_DOCUMENT_TYPE = 2;
    public static final int TBK_TRP2_ATTR_LENGTH_DOCUMENT_NUMBER = 15;
    public static final int TBK_TRP2_ATTR_LENGTH_BENEFICIARY = 60;
    public static final int TBK_TRP2_ATTR_LENGTH_EMAIL = 60;
    public static final int TBK_TRP2_ATTR_LENGTH_REFERENCE = 15;
    public static final int TBK_TRP2_ATTR_LENGTH_USER = 3;
    public static final int TBK_TRP2_ATTR_LENGTH_FORM_PAYMENT = 1;
    public static final int TBK_TRP2_ATTR_LENGTH_ACCOUNT = 14;
    public static final int TBK_TRP2_ATTR_LENGTH_CCI = 20;
    public static final int TBK_TRP2_ATTR_LENGTH_SAB = 4;
    public static final int TBK_TRP2_ATTR_LENGTH_ERROR_LINE = 6;
    public static final int TBK_TRP2_ATTR_LENGTH_ERROR_CODE = 4;
    public static final int TBK_TRP2_ATTR_LENGTH_ERROR_FIELD = 30;
    public static final int TBK_TRP2_ATTR_LENGTH_ERROR_MESSAGE = 100;
    public static final int TBK_OUTPUT_LENGTH_FILE_ROW_TRP2 = 509;
    public static final int TBK_INPUT_LENGTH_FILE_ROW_TRP2 = 369;
    public static final int TBK_TRP2_INITIAL_INDEX_MESSAGE = 121;
    public static final String EQUAL_SIGN_SEPARATOR = "=";
    public static final int TBK_TRP2_ATTR_LENGTH_OFFICE = 3;
    public static final int TBK_TRP2_ATTR_LENGTH_FILLER_NATIONAL_PAYMENT = 70;
    public static final int TBK_TRP2_ATTR_LENGTH_FILLER_FOREIGN_PAYMENT = 70;
    public static final int TBK_TRP2_EXCEL_ATTR_LENGTH_ACCOUNT = 11;
    // TRE2
    public static final int TBK_TRE2_ATTR_LENGTH_MEMBER = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_MESSAGE = 100;
    public static final int TBK_TRE2_ATTR_LENGTH_REGISTERS_NUMBER_OK = 6;
    public static final int TBK_TRE2_ATTR_LENGTH_REGISTERS_NUMBER_ERROR = 6;
    public static final int TBK_OUTPUT_LENGTH_FILE_ROW_TRE2 = 474;
    public static final String TRE2 = "TRE2";
    public static final int TBK_TRE2_INITIAL_INDEX_MESSAGE = 121;
    public static final int TBK_TRE2_FILE = 16;
    public static final int TBK_TRE2_ATTR_LENGTH_FILLER_NATIONAL_PAYMENT = 70;
    public static final int TBK_TRE2_ATTR_LENGTH_FILLER_FOREIGN_PAYMENT = 70;
    public static final int TBK_TRE2_ATTR_LENGTH_OFFICE = 3;
    public static final int TBK_TRE2_EXCEL_ATTR_LENGTH_ACCOUNT = 11;
    // TRE2 INPUT
    public static final int TBK_TRE2_ATTR_LENGTH_DOCUMENT_TYPE = 2;
    public static final int TBK_TRE2_ATTR_LENGTH_DOCUMENT_NUMBER = 15;
    public static final int TBK_TRE2_ATTR_LENGTH_EMPLOYEE_CODE = 8;
    public static final int TBK_TRE2_ATTR_LENGTH_EMPLOYEENAME = 60;
    public static final int TBK_TRE2_ATTR_LENGTH_NATIONAL_PAYMENT1 = 1;
    public static final int TBK_TRE2_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE1 = 14;
    public static final int TBK_TRE2_ATTR_LENGTH_CCINATIONAL1 = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_NATIONAL_PAYMENT2 = 1;
    public static final int TBK_TRE2_ATTR_LENGTH_NATIONAL_ACCOUNT_CODE2 = 14;
    public static final int TBK_TRE2_ATTR_LENGTH_CCINATIONAL2 = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_NATIONAL_PAYMENT3 = 1;
    public static final int TBK_TRE2_ATTR_LENGTH_NATIONALA_CCOUNT_CODE3 = 14;
    public static final int TBK_TRE2_ATTR_LENGTH_NATIONALCCI3 = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_INTERNATIONAL_PAYMENT_METHOD1 = 1;
    public static final int TBK_TRE2_ATTR_LENGTH_INTERNATIONAL_ACCOUNT_CODE1 = 14;
    public static final int TBK_TRE2_ATTR_LENGTH_CCI_INTERNATIONAL1 = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_INTERNATIONAL_PAYMENT_METHOD2 = 1;
    public static final int TBK_TRE2_ATTR_LENGTH_INTERNATIONAL_ACCOUNT_CODE2 = 14;
    public static final int TBK_TRE2_ATTR_LENGTH_CCI_INTERNATIONAL2 = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_INTERNATIONAL_PAYMENT_METHOD3 = 1;
    public static final int TBK_TRE2_ATTR_LENGTH_INTERNATIONAL_ACCOUNT_CODE3 = 14;
    public static final int TBK_TRE2_ATTR_LENGTH_CCIINTERNATIONAL3 = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_CURRENCY_CTS = 4;
    public static final int TBK_TRE2_ATTR_LENGTH_CTS_CCI = 20;
    public static final int TBK_TRE2_ATTR_LENGTH_CTS_CTA = 14;
    public static final int TBK_TRE2_ATTR_LENGTH_TYPE_CTS = 1;
    public static final int TBK_TRE2_ATTR_LENGTH_ERROR_LINE = 6;
    public static final int TBK_TRE2_ATTR_LENGTH_ERROR_CODE = 4;
    public static final int TBK_TRE2_ATTR_LENGTH_FIELD_ERROR = 30;
    public static final int TBK_TRE2_ATTR_LENGTH_ERROR_MESSAGE = 100;
    public static final int TBK_TRE2_EXCEL_ATTR_LENGTH_CTS_OFFICE = 3;

    public static final String TBK_TRCV_HEADER_INDICATOR = "******";
    public static final int TBK_TRP2_ATTR_ROW_INDEX_HEADER = 0;
    public static final int TBK_TRP2_ATTR_ROW_INDEX_BODY = 1;
    public static final int TBK_TRP2_ATTR_ROW_INDEX_DATE = 5000;

    public static final int TBK_TRE2_ATTR_ROW_INDEX_HEADER = 0;
    public static final int TBK_TRE2_ATTR_ROW_INDEX_BODY = 1;
    public static final int TBK_TRE2_ATTR_ROW_INDEX_DATE = 5000;

    public static final String TBK_DESCRIPTION_DOCUMENT_TYPE_CODE_01 = "DNI";
    public static final String TBK_CODE_DOCUMENT_TYPE_DNI = "01";
    public static final String TBK_DESCRIPTION_DOCUMENT_TYPE_CODE_02 = "Carnet Extranjer\u00EDa";
    public static final String TBK_CODE_DOCUMENT_TYPE_FOREIGN_CARD = "02";
    public static final String TBK_DESCRIPTION_DOCUMENT_TYPE_CODE_05 = "RUC";
    public static final String TBK_CODE_DOCUMENT_TYPE_RUC = "05";
    public static final String TBK_DESCRIPTION_DOCUMENT_TYPE_CODE_07 = "Pasaporte";
    public static final String TBK_CODE_DOCUMENT_TYPE_PASSPORT = "07";
    public static final String TBK_DEFAULT_MESSAGE_DOCUMENT_TYPE = "TIPO DE DOCUMENTO NO VALIDO";    
    public static final String TBK_MESSAGE_CELL_TYPE_ERROR = "Tipo de Celda Error";
    public static final String TBK_MESSAGE_CELL_TYPE_FORMULA = "Tipo de Celda Formula";
    public static final int TBK_OUPUT_ATTR_LENGTH_TEMPLATE_NUMBER = 5;
}
