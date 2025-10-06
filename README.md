# Test Plan

## Test 1: Account Creation & Login
**Objective:** Ensure a new user can register and log in.

### Steps:
1. Navigate to homepage.
2. Click Register.
3. Fill in details (name, email, password, etc.).
4. Submit → verify registration success.
5. Log out.
6. Log in again with the registered credentials.
7. Verify successful login (user name visible in header).

---

## Test 2: Purchase Flow
**Objective:** Validate end-to-end shopping and checkout.

### Steps:
1. Log in with an existing account.
2. Search for a product (e.g., “Laptop”).
3. Apply filter/sort options.
4. Open product details.
5. Add product to cart.
6. Go to cart → update quantity → accept terms.
7. Proceed to Checkout.
8. Fill in billing/shipping details.
9. Select shipping and payment method.
10. Place order → verify order confirmation page.
11. Go to My Account → Orders → verify order is listed.

---

## Test 3: Wishlist & Profile Management
**Objective:** Verify wishlist usage and account updates.

### Steps:
1. Log in.
2. Add any product to Wishlist.
3. Open wishlist → verify product added.
4. Move item from wishlist to cart.
5. Checkout that product (short flow).
6. Go to My Account → Customer info.
7. Update details (e.g., change password or address).
8. Save → verify confirmation message.
9. Log out and log back in (if password changed).
