package com.ubicompsystem.dojo.statemachine;

public enum RoomReservationStatus implements State<RoomReservationStatus>{
    WAITLIST{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{ CONFIRM };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    }, 
    PAYPEND{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{
                CONFIRM,
                PAYFAIL
            };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    }, 
    REQDENIED{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{};
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    },
    PAYFAIL{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{ WAITLIST };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{ PAYPEND };
        }
    }, 
    CONFIRM{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{
                REDEEM,
                CIWAITING,
                INHOUSE,
                CANCELED,
                NOSHOW
            };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    },
    CANCELED{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{
                REINSTATE
            };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{
                CONFIRM
            };
        }
    }, 
    REINSTATE{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{
                CONFIRM,
                CIWAITING,
                INHOUSE,
                NOSHOW
            };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{
                CANCELED
            };
        }
    }, 
    REDEEM{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{
                CANCELED
            };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{
                CONFIRM
            };
        }
    }, 
    CIWAITING{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{ INHOUSE, NOSHOW };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{ CONFIRM };
        }
    }, 
    INHOUSE{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{ COWAITING, CHECKOUT };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    },
    NOSHOW{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{};
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    }, 
    COWAITING{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{ CHECKOUT };
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{ INHOUSE };
        }
    }, 
    CHECKOUT{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{};
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    }, 
    UNKNOWN{
        @Override
        public RoomReservationStatus[] forwardStates(){
            return new RoomReservationStatus[]{};
        }

        @Override
        public RoomReservationStatus[] backwardStates(){
            return new RoomReservationStatus[]{};
        }
    };
}
