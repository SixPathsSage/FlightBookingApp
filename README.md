# Flight Booking App Low Level System Design

## Commands to Interact with the application

###### $ create_flight 10 10
`Flight Created Successfully with 10 Economy Seat(s) and 10 Business Seat(s)`
###### $ book_economy 1
`Booking{bookingId=1, bookedSeats=[Seat{number=1, type=ECONOMY}], status=ACTIVE, price=1000.0}`
###### $ book_business 1
`Booking{bookingId=2, bookedSeats=[Seat{number=11, type=BUSINESS}], status=ACTIVE, price=2000.0}`
###### $ get_booking_info 1
`Booking{bookingId=1, bookedSeats=[Seat{number=1, type=ECONOMY}], status=ACTIVE, price=1000.0}`
###### $ cancel_booking 2
`CancellationInfo{bookingId=2, cancelledSeats=[Seat{number=11, type=BUSINESS}], cancellationFee=400.0, refundAmount=1600.0}`
###### $ exit
