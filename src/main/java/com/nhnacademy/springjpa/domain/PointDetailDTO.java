package com.nhnacademy.springjpa.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PointDetailDTO {
    String getUserPointDetailID();

    String getUserPointChange();

    BigDecimal getUserPointChangeAmount();

    LocalDateTime getUserPointChangeDate();

}
