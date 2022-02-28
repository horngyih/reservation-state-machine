package com.ubicompsystem.dojo.statemachine;

public enum ReservationStatus implements State{
    WAITLIST{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{ CONFIRM };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{};
        }
    }, 
    PAYPEND{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{
                CONFIRM,
                PAYFAIL
            };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{};
        }
    }, 
    REQDENIED{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{ CONFIRM };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{};
        }
    },
    PAYFAIL{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{ CONFIRM };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{ PAYPEND };
        }
    }, 
    CONFIRM{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{
                CIWAITING,
                INHOUSE,
                CANCELED,
                NOSHOW
            };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{
                WAITLIST,
                PAYPEND,
                PAYFAIL,
                REQDENIED
            };
        }
    },
    CANCELED{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{
                REINSTATE
            };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{
                UNKNOWN
            };
        }
    }, 
    REINSTATE{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{
                CONFIRM,
                CIWAITING,
                INHOUSE,
                NOSHOW
            };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{
                CANCELED
            };
        }
    }, 
    REDEEM{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{
                CANCELED
            };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{
                CONFIRM
            };
        }
    }, 
    CIWAITING{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{ INHOUSE, NOSHOW };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{ CONFIRM };
        }
    }, 
    INHOUSE{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{ CHECKOUT };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{};
        }
    },
    NOSHOW{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{};
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{ CONFIRM, CIWAITING };
        }
    }, 
    COWAITING{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{ CHECKOUT };
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{ INHOUSE };
        }
    }, 
    CHECKOUT{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{};
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{ CONFIRM, CIWAITING };
        }
    }, 
    UNKNOWN{
        @Override
        public ReservationStatus[] forwardStates(){
            return new ReservationStatus[]{};
        }

        @Override
        public ReservationStatus[] backwardStates(){
            return new ReservationStatus[]{};
        }
    };
}
